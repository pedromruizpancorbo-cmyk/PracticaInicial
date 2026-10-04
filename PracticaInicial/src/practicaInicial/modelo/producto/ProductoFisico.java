package practicaInicial.modelo.producto;

public class ProductoFisico extends Producto {
    private double gastosEnvio;
    private double peso;

    public ProductoFisico(String nombre, double precio, int stock, double gastosEnvio, double peso) {
        super( nombre, precio, stock);
        this.gastosEnvio = gastosEnvio;
        this.peso = peso;
    }

    public double getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(float gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double calcularPrecioFinal() {
        return getPrecio() + gastosEnvio;
    }

    @Override
    public String toString() {
        return "ProductoFisico [ID=" + getId() + ", Nombre=" + getNombre() + ", Precio Base=" + getPrecio() + "€, Envío=" + gastosEnvio + "€, Stock=" + getStock() + "]";
    }
}
