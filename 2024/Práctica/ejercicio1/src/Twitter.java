import java.util.ArrayList;

public class Twitter {
    private ArrayList<Usuario> listaUsuarios;

    /**
     * Constructor de la clase Twitter - crea la lista de usuarios vacia y la lista
     * de tweets vacia
     * 
     * @param listaUsuarios
     */
    public Twitter() {
        listaUsuarios = new ArrayList<Usuario>();
    }

    /**
     * Añade un usuario a la lista de usuarios del twitter (si no existe)
     * 
     * @param usuario
     * @return true si se ha añadido el usuario, false en caso contrario
     */
    public Boolean addUsuario(Usuario u) {
        if (this.existeUsuario(u.getScreenName()) == null) { // si no existe el usuario lo agrega
            listaUsuarios.add(u);
            return true;
        } else {
            return false;
        }
    }

    /**
     * verifica si existe o no un usuario con el screenName indicado
     * 
     * @param screenName
     * @return true si existe, false en caso contrario
     */
    public Usuario existeUsuario(String screenName) {
        // uso stream para buscar el usuario en la lista de usuarios
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getScreenName().equals(screenName))
                .findFirst()
                .orElse(null); // si no encuentra el usuario devuelve null
    }

    /**
     * Elimina un usuario de la lista de usuarios del twitter
     * 
     * @param usuario
     */
    private void removeUsuario(Usuario usuario) {
        listaUsuarios.remove(usuario);
    }

    /**
     * Elimina el usuario de la lista de usuarios del twitter y todos sus tweets
     * 
     * @param screenName
     * @return true si se ha eliminado el usuario, false en caso contrario
     */
    public void eliminarUsuario(Usuario usuario) { // esta medio raro esto, pero dejarlo asi
        usuario.eliminarTweets();
        this.removeUsuario(usuario);
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}