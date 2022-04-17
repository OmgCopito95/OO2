import java.time.Duration;

public class Finished extends Estado {

    public Finished() {
        super("Finished");
    }

    @Override
    public void start(ToDoItem tarea) {
        // no hace nada
    }

    @Override
    public void togglePause(ToDoItem tarea) {
        // genera un error porque no se puede pausar una tarea finalizada
        throw new RuntimeException("No se puede pausar una tarea finalizada");
    }

    @Override
    public void finish(ToDoItem tarea) {
        // no hace nada
    }

    @Override
    public Duration workedTime(ToDoItem tarea) {
        return tarea.getDuracionTrabajada();
    }

    @Override
    public void addComment(ToDoItem tarea, String comment) {
        // no hace nada
    }

}
