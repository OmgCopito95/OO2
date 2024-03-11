import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Decodificador {

    private EstrategiaSugerir estrategiaSugerir;
    private List<Pelicula> listaPeliculasCompleta;
    private List<Pelicula> listaPeliculasReproducidas;

    public Decodificador() {
        this.listaPeliculasCompleta = new ArrayList<Pelicula>();
        this.listaPeliculasReproducidas = new ArrayList<Pelicula>();
    }

    public void configurarEstrategia(EstrategiaSugerir estrategiaSugerir) {
        this.estrategiaSugerir = estrategiaSugerir;
    }

    public ArrayList<Pelicula> obtenerPeliculasSugeridas() {
        return estrategiaSugerir.sugerirPeliculas(this);
    }

    public void agregarPeliculaADecodificador(Pelicula pelicula) {
        listaPeliculasCompleta.add(pelicula);
    }

    public void agregarPeliculaReproducida(Pelicula pelicula) {
        listaPeliculasReproducidas.add(pelicula);
    }

    public ArrayList<Pelicula> obtenerPeliculasMasRecientes() {
        // obtiene las ultimas 3 peliculas usando streams
        return this.ordenarListaPorEstreno(this.obtenerPeliculasNoReproducidas()).stream() // llama al ordenar por
                                                                                           // estreno
                .limit(3)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public ArrayList<Pelicula> obtenerPeliculasMayorPuntaje() {
        // ordena las peliculas por puntaje y año de estreno
        // ArrayList<Pelicula> listaOrdenada =
        // this.ordenarListaPorEstreno(this.obtenerPeliculasNoReproducidas()).stream()
        // .sorted((p1, p2) -> p2.getPuntaje() - p1.getPuntaje())
        // .limit(3)
        // .collect(Collectors.toCollection(ArrayList::new));

        return this.ordenarListaPorEstreno(this.obtenerPeliculasNoReproducidas()).stream()
                .sorted((p1, p2) -> p2.getPuntaje() - p1.getPuntaje())
                .limit(3)
                .collect(Collectors.toCollection(ArrayList::new));

        // return listaOrdenada.stream()
        // .limit(3)
        // .collect(Collectors.toCollection(ArrayList::new));

    }

    private ArrayList<Pelicula> ordenarListaPorEstreno(List<Pelicula> listaPeliculasCompleta) {
        // ordena la lista de peliculas completa por año de estreno

        ArrayList<Pelicula> listaOrdenada = listaPeliculasCompleta.stream()
                .sorted((p1, p2) -> p2.getAnioEstreno() - p1.getAnioEstreno()) // ordena por año de estreno
                .collect(Collectors.toCollection(ArrayList::new)); // convierte a ArrayList

        // System.out.println("listaPeliculasPorEstreno: " + listaOrdenada);

        return listaOrdenada;
    }

    private ArrayList<Pelicula> obtenerPeliculasNoReproducidas() {
        // obtiene las peliculas no reproducidas
        System.out.println("listaPeliculasCompleta: " + listaPeliculasCompleta);

        ArrayList<Pelicula> listaNoReproducidas = this.listaPeliculasCompleta.stream()
                .filter(pelicula -> !this.listaPeliculasReproducidas.contains(pelicula)) // filtra las peliculas que no
                                                                                         // estan en la lista de
                                                                                         // peliculas reproducidas
                .collect(Collectors.toCollection(ArrayList::new)); // convierte a ArrayList

        // System.out.println("listaPeliculasNoReproducidas: " + listaNoReproducidas);

        return listaNoReproducidas;

    }

    public ArrayList<Pelicula> obtenerPeliculasSimilares() {
        // obtiene las peliculas similares a alguna pelicula de la lista de peliculas
        // reproducidas
        return this.obtenerPeliculasNoReproducidas().stream()
                .filter(peli -> peli.getPeliculasSimilares().size() > 0) // filtra las peliculas que tienen peliculas
                                                                        // similares
                // .limit(3)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
