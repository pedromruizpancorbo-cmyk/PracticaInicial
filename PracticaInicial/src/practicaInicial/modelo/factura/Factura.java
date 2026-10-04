package practicaInicial.modelo.factura;

import practicaInicial.modelo.producto.Producto;
import practicaInicial.modelo.usuario.Usuario;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Factura {
    private LocalDate fecha;
    private Usuario usuario;
    private double total;
    private Map<Producto, Integer> lineasProducto;

    public Factura(Usuario usuario, double total, Map<Producto, Integer> lineasProducto) {
        this.fecha = LocalDate.now();
        this.usuario = usuario;
        this.total = total;
        this.lineasProducto = new HashMap<>(lineasProducto);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Map<Producto, Integer> getLineasProducto() {
        return lineasProducto;
    }

    public void setLineasProducto(Map<Producto, Integer> lineasProducto) {
        this.lineasProducto = lineasProducto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void imprimirFactura() {
        System.out.println("=========================================");
        System.out.println("            FACTURA DE COMPRA            ");
        System.out.println("=========================================");
        System.out.println(" | Fecha: " + fecha);
        System.out.println("Cliente: " + usuario.getNombre() + " (" + usuario.getEmail() + ")");
        System.out.println("-----------------------------------------");
        lineasProducto.forEach((producto, cant) -> {
            System.out.printf("%-20s x%d  %.2f€\n",
                    producto.getNombre(), cant, producto.calcularPrecioFinal() * cant);
        });
        System.out.println("-----------------------------------------");
        System.out.printf("TOTAL A PAGAR: %.2f€\n", total);
        System.out.println("=========================================\n");
    }

    public String toString() {
        return "Factura | Fecha: " + fecha + " | Cliente: " + usuario.getNombre() + " | Total: " + total + "€";
    }
}
