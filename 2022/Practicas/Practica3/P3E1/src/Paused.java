import java.time.Duration;

public class Paused extends Estado {

    public Paused() {
        super("Paused");
    }

    @Override
    public void start(ToDoItem tarea) {
        // no hace nada
    }

    @Override
    public void togglePause(ToDoItem tarea) {
        // no hace nada
    }

    @Override
    public void finish(ToDoItem tarea) {
        tarea.cambiarEstado(new Finished());
        // actualiza el tiempo de duracion de la tarea
    }

    @Override
    public Duration workedTime(ToDoItem tarea) {
        return tarea.getDuracionTrabajada();
    }

    @Override
    public void addComment(ToDoItem tarea, String comment) {
        tarea.agregarComentario(comment);
    }
}
