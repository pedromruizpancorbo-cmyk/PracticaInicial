package practicaInicial;

import practicaInicial.modelo.carrito.Carrito;
import practicaInicial.modelo.carrito.GestorCarrito;
import practicaInicial.modelo.factura.GestorFactura;
import practicaInicial.modelo.producto.GestorProducto;
import practicaInicial.modelo.producto.Producto;
import practicaInicial.modelo.producto.ProductoDigital;
import practicaInicial.modelo.producto.ProductoFisico;
import practicaInicial.modelo.usuario.GestorUsuarios;
import practicaInicial.modelo.usuario.Usuario;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Vista vista = new Vista();

        HashMap<Integer, Producto> productos = new HashMap<>();
        Map<Producto, Integer> articulos = new HashMap<>();

        // Productos Físicos
        ProductoFisico pf1 = new ProductoFisico("Teclado Mecánico", 59.99, 10, 4.50f, 0.900);
        ProductoFisico pf2 = new ProductoFisico("Ratón Gaming", 29.95, 5, 3.00f, 0.250);

        // Productos Digitales
        ProductoDigital pd1 = new ProductoDigital("Antivirus Pro 1 Año", 19.99, 100, 250, "LICENSE-2026-X1");
        ProductoDigital pd2 = new ProductoDigital("E-book Java Avanzado", 9.90, 50, 15, "PDF-DOWNLOAD-2026");

        // Añadir los productos al mapa inicial
        productos.put(pf1.getId(), pf1);
        productos.put(pf2.getId(), pf2);
        productos.put(pd1.getId(), pd1);
        productos.put(pd2.getId(), pd2);

        Carrito carrito = new Carrito(articulos);

        GestorProducto gestorProducto = new GestorProducto(productos);
        GestorUsuarios gestorUsuarios = new GestorUsuarios();
        GestorCarrito gestorCarrito = new GestorCarrito(carrito);
        GestorFactura gestorFactura = new GestorFactura();
        gestorFactura.cargarHistorialDesdeCSV(gestorUsuarios);

        Usuario u1 = new Usuario("Juan Pérez", "juan@email.com");
        Usuario u2 = new Usuario("María Gómez", "maria@email.com");

        gestorUsuarios.altaUsuario(u1);
        gestorUsuarios.altaUsuario(u2);

        Controlador controlador = new Controlador(gestorProducto, gestorUsuarios, gestorCarrito, gestorFactura, vista);
        controlador.iniciar();
    }
}
