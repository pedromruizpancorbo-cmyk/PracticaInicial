package practicaInicial.modelo.carrito;

import practicaInicial.excepciones.ElementoNoEncontradoException;
import practicaInicial.excepciones.StockInsuficienteException;
import practicaInicial.modelo.producto.GestorProducto;
import practicaInicial.modelo.producto.Producto;

import java.util.Map;

public class GestorCarrito {
    private Carrito carrito;

    public GestorCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public boolean agregarProducto(Producto producto, int cantidad, GestorProducto gestorProducto) throws StockInsuficienteException,
            ElementoNoEncontradoException{
        if (producto == null || cantidad <= 0) {
            return false;
        }
        Producto productoBuscado =  gestorProducto.buscarProductoPorID(producto.getId());
        if (productoBuscado == null) {
            return false;
        }
//        Map <Producto, Integer> carroActual = carrito.getCarro();
        int cantidadActual = obtenerCantidadPorId(productoBuscado.getId());
        int cantidadNueva = cantidadActual + cantidad;
        if (cantidadNueva > productoBuscado.getStock()) {
            throw  new StockInsuficienteException("No hay suficiente stock disponible");
        }

        carrito.getArticulos().put(producto, cantidadNueva);

        return true;
    }

    public boolean quitarProducto (int id, GestorProducto gestorProducto) throws ElementoNoEncontradoException{
        if (this.carrito == null || this.carrito.getArticulos() == null) {
            return false;
        }
        Producto productoBuscado =  gestorProducto.buscarProductoPorID(id);
        if (productoBuscado != null) {
            carrito.getArticulos().remove(productoBuscado);
            return true;
        }
        return false;
    }

    public int obtenerCantidadPorId(int id) {
        Map <Producto, Integer> productosCarro = this.carrito.getArticulos();

        for (Map.Entry<Producto, Integer> entry : productosCarro.entrySet()) {
            Producto producto = entry.getKey();

            if (producto.getId() == id) {
                return entry.getValue();
            }
        }

        return 0;
    }

    public double obtenerTotal() {
        if (this.carrito == null) {
            return 0;
        }

        double total = 0;
        Map<Producto, Integer> productosCarro = this.carrito.getArticulos();

        for (Map.Entry<Producto, Integer> entry : productosCarro.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println(producto.getNombre() + " -- Precio/u: " + producto.getPrecio() + " -- Cant: " + cantidad);

            total = total + (producto.getPrecio() * cantidad);
        }

        return total;
    }
}
