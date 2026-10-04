package practicaInicial.excepciones;

public class CarritoVacioException extends Exception {
    public CarritoVacioException(String mensaje) {
        super(mensaje);
    }
}