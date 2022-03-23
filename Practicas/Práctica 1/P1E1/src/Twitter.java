

import java.util.ArrayList;

public class Twitter {
    private ArrayList<Usuario> listaUsuarios;

    /**
     * Constructor de la clase Twitter - crea la lista de usuarios vacia y la lista
     * de tweets vacia
     */
    public Twitter() {
        listaUsuarios = new ArrayList<Usuario>();
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Añade un usuario a la lista de usuarios del twitter (si no existe)
     * 
     * @param usuario
     * @return true si se ha añadido el usuario, false en caso contrario
     */
    public Usuario addUsuario(String screenName) {
        if (!this.existeUsuario(screenName)) { // si no existe el usuario lo agrega
            listaUsuarios.add(new Usuario(screenName));
            return listaUsuarios.get(listaUsuarios.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * verifica si existe o no un usuario con el screenName indicado
     * 
     * @param screenName
     * @return true si existe, false en caso contrario
     */
    //
    public Boolean existeUsuario(String screenName) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getScreenName().equals(screenName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un usuario de la lista de usuarios del twitter
     * 
     * @param usuario
     */
    public void removeUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    /**
     * Elimina el usuario de la lista de usuarios del twitter y todos sus tweets
     * 
     * @param screenName
     * @return true si se ha eliminado el usuario, false en caso contrario
     */
    public boolean eliminarUsuario(Usuario usuario) {
        if (usuario != null) {
            usuario.getListaTweets().clear();
            this.removeUsuario(usuario);
            return true;
        } else {
            return false;
        }
    }

    @Deprecated
    /**
     * Busca un usuario en la lista de usuarios del twitter
     * 
     * @param screenName
     * @return el usuario si lo encuentra, null en caso contrario
     */
    public Usuario buscarUsuario(String screenName) {
        // busca el usuario en la lista de usuarios
        for (Usuario u : listaUsuarios) {
            if (u.getScreenName().equals(screenName)) {
                return u;
            }
        }
        return null;
    }

}