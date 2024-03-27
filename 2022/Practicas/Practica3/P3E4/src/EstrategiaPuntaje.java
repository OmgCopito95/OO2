import java.util.ArrayList;

public class EstrategiaPuntaje implements EstrategiaSugerir{

    @Override
    public ArrayList<Pelicula> sugerirPeliculas(Decodificador d) {
        return d.obtenerPeliculasMayorPuntaje();
    }
    
}
