

// atributo: texto string de 1 a 140 caracteres - origen: Tweet
// metodos: getTexto(), setTexto(), toString()

public class Tweet {
    private String texto;
    private Tweet origen;
    

    /**
     * Constructor de la clase Tweet
     * 
     * @param texto
     */
    public Tweet(String texto, Tweet origen) {
        this.texto = texto;
        this.origen = origen;
    }

    public String getTexto() {
        return texto;
    }

    /**
     * Devuelve una cadena con los datos del tweet
     */
    public String toString() {
        return texto;
    }

}
