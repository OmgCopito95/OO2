import java.util.ArrayList;

public class EstrategiaNovedad implements EstrategiaSugerir{

    

    @Override
    public ArrayList<Pelicula> sugerirPeliculas(Decodificador d) {
        //peliculas mas recientes        
        return d.obtenerPeliculasMasRecientes();
    }
    
}
