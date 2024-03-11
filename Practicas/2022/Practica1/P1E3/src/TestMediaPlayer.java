import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestMediaPlayer {

    MediaPlayer mediaPlayer;

    @Before
    public void setUp() {
        mediaPlayer = new MediaPlayer();
        Media m1 = new VideoFile();
        Media m2 = new Audio();
        Media m3 = new VideoStreamAdapter();
        mediaPlayer.agregarMedia(m1);
        mediaPlayer.agregarMedia(m2);
        mediaPlayer.agregarMedia(m3);

    }

    @Test
    public void testCantidadMedia(){
        assertEquals(3, mediaPlayer.getListaMedia().size());
    }

    @Test
    public void testReproducir() {
        mediaPlayer.reproducirTodo();
    }

}
