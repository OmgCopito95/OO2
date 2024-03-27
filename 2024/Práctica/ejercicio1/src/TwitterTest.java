import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TwitterTest {

    Twitter twitter;
    Usuario usuario1;
    Usuario usuario2;

    @Before
    public void setUp() {
        twitter = new Twitter(); 
        usuario1 = new Usuario("juan");
        usuario2 = new Usuario("pedro");
    }

    @Test
    public void testUsuarioExistente() {
        twitter.addUsuario(usuario1);
        assertEquals(true, twitter.existeUsuario("juan") != null);
    }

    @Test
    public void TestTwittear() {
        // el test verifica si se crea un tweet correctamente

        twitter.addUsuario(usuario1);
        usuario1.twittear("hola");

        assertEquals(1, usuario1.getListaTweets().size());
    }

    @Test
    public void TestEliminarUsuarioYSusTweets() {
        // el test verifica si se elimina un usuario y sus tweets

        twitter.addUsuario(usuario1);
        twitter.addUsuario(usuario2);

        usuario1.twittear("hola1");
        usuario1.twittear("hola2");
        usuario1.twittear("hola3");
        usuario2.twittear("hola4");


        twitter.eliminarUsuario(usuario1);

        assertEquals(false, twitter.getListaUsuarios().contains(usuario1));
        assertEquals(true, usuario1.getListaTweets().isEmpty());
    }

    


    // Falta hacer:
    // Cada usuario conoce todos los Tweets que hizo.
    // Twitter debe conocer a todos los usuarios del sistema.
    // Los tweets deben tener un texto de 1 carácter como mínimo y 140 caracteres como máximo.

}
