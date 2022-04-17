import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestToDoItem {

    private ToDoItem tarea1;

    @Before
    public void setUp() {
        tarea1 = new ToDoItem("Tarea 1");
    }

    @Test
    public void comenzarTarea() {
        tarea1.start();
        assertEquals("InProgress", tarea1.getEstado());
    }

    @Test
    public void pausarTarea() {
        tarea1.start();
        tarea1.togglePause();
        assertEquals("Paused", tarea1.getEstado());
    }

    @Test
    public void terminarTarea() {
        tarea1.start();
        tarea1.finish();
        assertEquals("Finished", tarea1.getEstado());
    }

    // test para verificar que se agrega un comentario
    @Test
    public void agregarComentario() {
        tarea1.start();
        tarea1.addComment("Comentario 1");
        assertEquals("Comentario 1", tarea1.getComentarios().get(0));
    }

    //test para verificar los errores
    @Test(expected = RuntimeException.class)
    public void errorPausarTareaFinalizada() {
        tarea1.start();
        tarea1.finish();
        tarea1.togglePause();
    }



}
