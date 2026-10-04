package practicaInicial.modelo.producto;

import practicaInicial.excepciones.ElementoNoEncontradoException;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorProducto {
    private HashMap<Integer, Producto> productos;

    public GestorProducto(HashMap<Integer, Producto> productos) {
        this.productos = productos;
    }

    public boolean altaProducto(Producto producto){
        if(productos.containsKey(producto.getId())){
            return false;
        }
        productos.put(producto.getId(), producto);
        return true;
    }

//    public boolean bajaProducto(int id){
//        if(productos.containsKey(id)){
//            productos.remove(id);
//            return true;
//        }
//        return false;
//    }

    public boolean bajaProducto(int id) throws ElementoNoEncontradoException {
        if (!productos.containsKey(id)) {
            throw new ElementoNoEncontradoException("No existe ningún producto con el ID " + id);
        }
        productos.remove(id);
        return true;
    }

    public void listadoProductos(){
        ArrayList<Producto> productos1 = new ArrayList<>(productos.values());
        for(Producto producto : productos1){
            System.out.println(producto);
        }
    }

    public Producto buscarProductoPorPrecio(double precio) {
        ArrayList<Producto> productos1 = new ArrayList<>(productos.values());
        for (Producto producto : productos1) {
            if (producto.getPrecio() == precio) return producto;
        }
        return null;
    }

    public Producto buscarProductoPorID(int id) throws ElementoNoEncontradoException {
        ArrayList<Producto> productos1 = new ArrayList<>(productos.values());
        for (Producto producto : productos1) {
            if (producto.getId() == id){
                return producto;
            }
        }
        throw new ElementoNoEncontradoException("No se encontró ningún producto con el ID " + id);
    }

}
