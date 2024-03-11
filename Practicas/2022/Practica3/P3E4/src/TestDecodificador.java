import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestDecodificador {

    Decodificador d;
    Pelicula p1;
    Pelicula p2;
    Pelicula p3;
    Pelicula p4;
    Pelicula p5;
    Pelicula p6;

    @Before
    public void setUp() {

        d = new Decodificador();
        p1 = new Pelicula("Thor", 2007, 9);
        p2 = new Pelicula("Capitan America", 2016, 8);
        p3 = new Pelicula("Iron man", 2010, 9);
        p4 = new Pelicula("Dunkirk", 2017, 9);
        p5 = new Pelicula("Rocky", 1976, 10);
        p6 = new Pelicula("Rambo", 1979, 8);

        d.agregarPeliculaADecodificador(p1);
        d.agregarPeliculaADecodificador(p2);
        d.agregarPeliculaADecodificador(p3);
        d.agregarPeliculaADecodificador(p4);
        d.agregarPeliculaADecodificador(p5);
        d.agregarPeliculaADecodificador(p6);

        p1.agregarPeliculaSimilar(p2);
        p1.agregarPeliculaSimilar(p3);

        p2.agregarPeliculaSimilar(p1);
        p2.agregarPeliculaSimilar(p3);

        p3.agregarPeliculaSimilar(p1);
        p3.agregarPeliculaSimilar(p2);

        p5.agregarPeliculaSimilar(p6);

        p6.agregarPeliculaSimilar(p5);

        
        d.agregarPeliculaReproducida(p1);
        d.agregarPeliculaReproducida(p5);

    }

    

    @Test
    public void testDecodificadorNovedad(){
    d.configurarEstrategia(new EstrategiaNovedad());
    ArrayList<Pelicula> lista = d.obtenerPeliculasSimilares();

    assertEquals("Capitan America", lista.get(0).getTitulo());
    assertEquals("Iron man", lista.get(1).getTitulo());
    assertEquals("Rambo", lista.get(2).getTitulo());
    }

    @Test
    public void testDecodificadoSimilar(){
    d.configurarEstrategia(new EstrategiaSimilaridad());
    ArrayList<Pelicula> lista = d.obtenerPeliculasSugeridas();

    assertEquals("Capitan America", lista.get(0).getTitulo());
    assertEquals("Iron man", lista.get(1).getTitulo());
    assertEquals("Rambo", lista.get(2).getTitulo());
    }
    
    @Test
    public void testDecodificadorPuntaje() {
        d.configurarEstrategia(new EstrategiaPuntaje());
        ArrayList<Pelicula> lista = d.obtenerPeliculasSugeridas();

        assertEquals("Dunkirk", lista.get(0).getTitulo());
        assertEquals("Iron man", lista.get(1).getTitulo());
        assertEquals("Capitan America", lista.get(2).getTitulo());
    }

}
