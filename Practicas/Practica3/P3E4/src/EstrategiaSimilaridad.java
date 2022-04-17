import java.util.ArrayList;

public class EstrategiaSimilaridad implements EstrategiaSugerir{

    @Override
    public ArrayList<Pelicula> sugerirPeliculas(Decodificador d) {
        return d.obtenerPeliculasSimilares();
    }
    
}
