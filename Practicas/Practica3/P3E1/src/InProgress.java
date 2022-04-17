import java.time.Duration;

public class InProgress extends Estado {

    public InProgress() {
        super("InProgress");
    }

    @Override
    public void start(ToDoItem tarea) {
        // no hace nada
    }

    @Override
    public void togglePause(ToDoItem tarea) {
        tarea.cambiarEstado(new Paused());
    }

    @Override
    public void finish(ToDoItem tarea) {
        tarea.cambiarEstado(new Finished());
    }

    @Override
    public Duration workedTime(ToDoItem tarea) {
        System.out.println("holaaa");
        return tarea.getDuracionTrabajada();
    }

    @Override
    public void addComment(ToDoItem tarea, String comment) {
        tarea.agregarComentario(comment);
    }

}
