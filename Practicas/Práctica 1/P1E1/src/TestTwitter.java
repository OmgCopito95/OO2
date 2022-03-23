import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTwitter {
    @Test

    public void testUsuarioExistente() {
        // el test verifica si existe o no un usuario con el screenName indicado
        Twitter twitter = new Twitter();

        Usuario usuario1 = twitter.addUsuario("juan");

        assertEquals(null, twitter.addUsuario("juan")); // el resultado esperado es false porque ya existe el usuario
    }

    @Test
    public void TestEliminarUsuarioYSusTweets() {
        // el test verifica si se elimina un usuario y sus tweets
        Twitter twitter = new Twitter();

        Usuario usuario1 = twitter.addUsuario("juan");
        Usuario usuario2 = twitter.addUsuario("pedro");
        Usuario usuario3 = twitter.addUsuario("maria");

        usuario1.twittear("hola1");
        usuario1.twittear("hola2");
        usuario1.twittear("hola3");
        usuario2.twittear("hola4");


        twitter.eliminarUsuario(usuario1);

        assertEquals(false, twitter.getListaUsuarios().contains(usuario1));
        assertEquals(true, usuario1.getListaTweets().isEmpty());
    }

}
