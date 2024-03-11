import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {
    // lista de media
    private List<Media> listaMedia;

    // construtor nulo
    public MediaPlayer() {
        // crea la lista vacia de media
        listaMedia = new ArrayList<Media>();
    }

    public void agregarMedia(Media media) {
        listaMedia.add(media);
    }

    public void reproducirMedia(Media m){
        m.play();
    }

    public List<Media> getListaMedia() {
        return listaMedia;
    }

    public void reproducirTodo() {
        // recorre la lista de media utilizando streams
        listaMedia.stream().forEach(media -> media.play());
    }
    

}
