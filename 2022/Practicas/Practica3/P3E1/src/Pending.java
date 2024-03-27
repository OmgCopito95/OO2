import java.time.Duration;

public class Pending extends Estado {

    public Pending() {
        super("Pending");
    }

    @Override
    public void start(ToDoItem tarea) {
        tarea.cambiarEstado(new InProgress()); 
    }

    @Override
    public void togglePause(ToDoItem tarea) {
        // genera un error porque no se puede pausar una tarea pendiente
        throw new RuntimeException("No se puede pausar una tarea pendiente");
    }

    @Override
    public void finish(ToDoItem tarea) {
        // no hace nada        
    }

    @Override
    public Duration workedTime(ToDoItem tarea) {
        // genera un error
        throw new RuntimeException("No se puede calcular el tiempo trabajado de una tarea pendiente");
    }

    @Override
    public void addComment(ToDoItem tarea, String comment) {
        tarea.agregarComentario(comment);        
    }
    


    

}
