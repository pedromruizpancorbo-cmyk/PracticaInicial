package practicaInicial.modelo.usuario;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private boolean estado;

    private static int contadorId = 1;

    public Usuario(String nombre, String email) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.email = email;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String estadoTexto = (estado) ? "Activo":"Inactivo";
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", estado=" + estadoTexto +
                '}';
    }
}
