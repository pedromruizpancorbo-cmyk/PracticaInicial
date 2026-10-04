package practicaInicial.modelo.usuario;

import practicaInicial.excepciones.ElementoNoEncontradoException;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorUsuarios {
    private HashMap<Integer, Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public GestorUsuarios(HashMap<Integer, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean altaUsuario(Usuario usuario){
        if(usuarios.containsKey(usuario.getId())){
            return false;
        }
        usuarios.put(usuario.getId(), usuario);
        return true;
    }

    public boolean altaUsuario(String nombre, String email) {
        Usuario nuevoUsuario = new Usuario(nombre, email);
        usuarios.put(nuevoUsuario.getId(), nuevoUsuario);
        return true;
    }

    public boolean bajaUsuario(int id) throws ElementoNoEncontradoException {
        if (!usuarios.containsKey(id)) {
            throw new ElementoNoEncontradoException("No existe ningún usuario con el ID " + id);
        }

        usuarios.remove(id);
        return true;
    }

    public void listadoUsuarios(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>(usuarios.values());
        for(Usuario usuario : listaUsuarios){
            System.out.println(usuario);
        }
    }
    public void listadoUsuariosActivos(){
        ArrayList<Usuario> listaUsuarios = new ArrayList<>(usuarios.values());
        for(Usuario usuario : listaUsuarios){
            if(usuario.isEstado()) System.out.println(usuario);
        }
    }

    public Usuario buscarPorId(int id) throws ElementoNoEncontradoException {
        Usuario usuario = usuarios.get(id);

        if (usuario == null) {
            throw new ElementoNoEncontradoException("No existe ningún usuario registrado con el ID " + id);
        }

        return usuario;
    }

}
