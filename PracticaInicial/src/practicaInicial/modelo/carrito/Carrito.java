package practicaInicial.modelo.carrito;

import practicaInicial.modelo.producto.Producto;

import java.util.Map;

public class Carrito {
    private Map<Producto, Integer> articulos;

    public Carrito(Map<Producto, Integer> articulos) {
        this.articulos = articulos;
    }

    public Map<Producto, Integer> getArticulos() {
        return articulos;
    }

    public void setArticulos(Map<Producto, Integer> articulos) {
        this.articulos = articulos;
    }
}
