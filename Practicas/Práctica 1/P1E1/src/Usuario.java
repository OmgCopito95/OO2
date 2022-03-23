

import java.util.ArrayList;

// atributos: screenName: String - lista de tweets: ArrayList<Tweet> 
// metodos: getScreenName(), getListaTweets(), addTweet(), removeTweet(), toString()

public class Usuario {
    private String screenName;
    private ArrayList<Tweet> listaTweets;

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

    public ArrayList<Tweet> getListaTweets() {
        return listaTweets;
    }

    /**
     * Añade un tweet a la lista de tweets del usuario
     * 
     * @param tweet
     */
    public void addTweet(Tweet tweet) {
        listaTweets.add(tweet);
    }

    /**
     * Elimina un tweet de la lista de tweets del usuario
     * 
     * @param tweet
     */
    public void removeTweet(Tweet tweet) {
        listaTweets.remove(tweet);
    }

    /**
     * Devuelve una cadena con los datos del usuario
     */
    public String toString() {
        return screenName;
    }

    /**
     * Crea un tweet si es que cumple el texto
     * @param texto
     * @return true si se ha creado el tweet, false en caso contrario
     */
    public boolean twittear(String texto) {
        // verificar si el texto es valido (1 a 140 caracteres)
        if (this.verificarTexto(texto)) {
            this.addTweet(new Tweet(texto, null));
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
        if (texto.length() > 140 || texto.length() < 1) {
            return false;
        }
        return true;
    }

    public void retwittear (Tweet t){
        // crea tweet con el texto del tweet original y el origen del tweet original. lo agrega a la lista de tweets del usuario
        Tweet tw = new Tweet(t.getTexto(), t);
        this.addTweet(tw);
    }
}
