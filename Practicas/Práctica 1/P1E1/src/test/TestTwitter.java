import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestTwitter {

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

        twitter.addUsuario("juan");
        assertEquals(null, twitter.addUsuario("juan")); // el resultado esperado es false porque ya existe el usuario
    }

    @Test
    public void TestEliminarUsuarioYSusTweets() {
        // el test verifica si se elimina un usuario y sus tweets

        usuario1 = twitter.addUsuario("juan");
        usuario2 = twitter.addUsuario("pedro");

        usuario1.twittear("hola1");
        usuario1.twittear("hola2");
        usuario1.twittear("hola3");
        usuario2.twittear("hola4");


        twitter.eliminarUsuario(usuario1);

        assertEquals(false, twitter.getListaUsuarios().contains(usuario1));
        assertEquals(true, usuario1.getListaTweets().isEmpty());
    }

}
