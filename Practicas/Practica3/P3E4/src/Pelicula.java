import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    // atributos: titulo, año de estreno, peliculas similares y puntaje

    private String titulo;
    private int anioEstreno;
    private List<Pelicula> peliculasSimilares;
    private int puntaje;

    // constructor
    public Pelicula(String titulo, int anioEstreno, int puntaje) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.peliculasSimilares = new ArrayList<Pelicula>();
        this.puntaje = puntaje;
    }

    // getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public List<Pelicula> getPeliculasSimilares() {
        return peliculasSimilares;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    // metodos
    public void agregarPeliculaSimilar(Pelicula pelicula) {
        this.peliculasSimilares.add(pelicula);
    }

    // obtiene peliculas similares a la pelicula actual
    public List<Pelicula> obtenerPeliculasSimilares() {
        return this.peliculasSimilares;
    }
    
}
