package practicaInicial.modelo.factura;

import practicaInicial.excepciones.CarritoVacioException;
import practicaInicial.modelo.carrito.Carrito;
import practicaInicial.modelo.producto.Producto;
import practicaInicial.modelo.usuario.GestorUsuarios;
import practicaInicial.modelo.usuario.Usuario;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorFactura {
    private ArrayList<Factura> historialPedidos = new ArrayList<>();

    public Factura crearFactura(Usuario usuario, Carrito carrito) throws CarritoVacioException {
        if (usuario == null) {
            System.out.println("Error. El usuario no existe.");
            return null;
        }

        if (carrito == null || carrito.getArticulos().isEmpty()) {
            throw new CarritoVacioException("No se puede crear la factura porque el carrito está vacío");
        }

        Map<Producto, Integer> articulos = carrito.getArticulos();

        for (Map.Entry<Producto, Integer> entry : articulos.entrySet()) {
            Producto p = entry.getKey();

            p.setStock(p.getStock() - entry.getValue());
        }

        double total = 0;
        for (Map.Entry<Producto, Integer> entry : articulos.entrySet()) {
            total += entry.getKey().calcularPrecioFinal() * entry.getValue();
        }

        Factura factura = new Factura(usuario, total, articulos);
        historialPedidos.add(factura);

        articulos.clear();

        return factura;
    }

    public void consultarHistorial() {
        if (historialPedidos.isEmpty()) {
            System.out.println("No hay pedidos en el historial");
            return;
        }
        System.out.println("\n--- HISTORIAL DE PEDIDOS ---");
        for (Factura f : historialPedidos) {
            System.out.println(f);
        }
    }

    public boolean exportarHistorialCSV() {
        if (historialPedidos.isEmpty()) {
            return false;
        }

        String rutaArchivo = "archivos/historialpedidos.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {

            for (Factura f : historialPedidos) {
                String linea = f.getFecha() + ";" +
                        f.getUsuario().getNombre() + ";" +
                        f.getUsuario().getEmail() + ";" + f.getTotal();
                bw.write(linea);
                bw.newLine();
            }
            return true;

        } catch (IOException e) {
            System.out.println("ERROR:" + e.getMessage());
            return false;
        }
    }

    public void cargarHistorialDesdeCSV(GestorUsuarios gestorUsuarios) {
        File archivo = new File("archivos", "historialpedidos.csv");

        if (!archivo.exists()) {
            System.out.println("No se encontró ningún CSV de historial de pedidos. Se iniciará un nuevo historial");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(";");

                if (datos.length >= 4) {
                    LocalDate fecha = LocalDate.parse(datos[0]);
                    String nombreCliente = datos[1];
                    String emailCliente = datos[2];
                    double total = Double.parseDouble(datos[3].replace(",", "."));


                    Usuario usuario = new Usuario(nombreCliente, emailCliente);
                    Factura factura = new Factura(usuario, total, new HashMap<>());
                    factura.setFecha(fecha);

                    this.historialPedidos.add(factura);
                }
            }
            System.out.println("Se ha cargado el historial.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

