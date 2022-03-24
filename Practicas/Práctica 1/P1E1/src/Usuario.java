
import java.util.ArrayList;
import java.util.List;

// atributos: screenName: String - lista de tweets: ArrayList<Tweet> 
// metodos: getScreenName(), getListaTweets(), addTweet(), removeTweet(), toString()

public class Usuario {
    private String screenName;
    private List<Tweet> listaTweets;

    /**
     * Constructor de la clase Usuario - crea la lista de tweets vacia
     * 
     * @param screenName
     */
    public Usuario(String screenName) {
        this.screenName = screenName;
        listaTweets = new ArrayList<Tweet>();
    }

    public String getScreenName() {
        return screenName;
    }

    public List<Tweet> getListaTweets() {
        return listaTweets;
    }

    /**
     * Añade un tweet a la lista de tweets del usuario
     * 
     * @param tweet
     */
    private void addTweet(Tweet tweet) {
        listaTweets.add(tweet);
    }

    /**
     * Crea un tweet si es que cumple el texto
     * 
     * @param texto
     * @return true si se ha creado el tweet, false en caso contrario
     */
    public boolean twittear(String texto) {
        // verificar si el texto es valido (1 a 140 caracteres)
        if (this.verificarTexto(texto)) {
            this.addTweet(new Tweet(texto));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica si el texto es valido (1 a 140 caracteres)
     * 
     * @param texto
     * @return true si es valido, false en caso contrario
     */
    private Boolean verificarTexto(String texto) {
        return !(texto.length() > 140 || texto.length() < 1);
    }

    public void retwittear(Tweet t) {
        // crea tweet con el texto del tweet original y el origen del tweet original. lo
        // agrega a la lista de tweets del usuario
        Tweet tw = new Tweet(t.getTexto(), t);
        this.addTweet(tw);
    }

    public boolean seLlama(String nombre){
        return this.getScreenName().equals(nombre);
    }

    public void eliminarTweets(){
        this.getListaTweets().clear();
    }
}
