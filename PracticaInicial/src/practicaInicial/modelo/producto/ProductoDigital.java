package practicaInicial.modelo.producto;

public class ProductoDigital extends Producto {
    private int tamanio;
    private String licencia;

    public ProductoDigital( String nombre, double precio, int stock, int tamanio, String licencia) {
        super(nombre, precio, stock);
        this.tamanio = tamanio;
        this.licencia = licencia;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecio();
    }

    @Override
    public String toString() {
        return "ProductoDigital [ID=" + getId() + ", Nombre=" + getNombre() + ", Precio=" + getPrecio() + "€, Licencia=" + licencia + ", MB=" + tamanio + ", Stock=" + getStock() + "]";
    }
}
