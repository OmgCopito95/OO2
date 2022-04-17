import java.time.Duration;

public abstract class Estado {
    private String nombre;

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // metodos abstractos: start, togglePause, finish, workedTime, addComment

    public abstract void start(ToDoItem tarea);

    public abstract void togglePause(ToDoItem tarea);

    public abstract void finish(ToDoItem tarea);

    public abstract Duration workedTime(ToDoItem tarea);

    public abstract void addComment(ToDoItem tarea, String comment);

}
