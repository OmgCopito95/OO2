import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {

    private Estado estado;
    private String nombre;
    private List<String> comentarios;
    private LocalDateTime comienzo;
    private LocalDateTime fin;

    /**
     * Instancia un ToDoItem nuevo en estado pending con <name> como nombre.
     */
    public ToDoItem(String name) {
        this.estado = new Pending();
        this.nombre = name;
        this.comentarios = new ArrayList<String>();
        this.comienzo = null;
        this.fin = null;
    }

    /**
     * Pasa el ToDoItem a in-progress (siempre y cuando su estado actual sea
     * pending, si se encuentra en otro estado, no hace nada)
     */
    public void start() {
        estado.start(this);

        comienzo = LocalDateTime.now();
    }

    /**
     * Pasa la tarea a paused si su estado es in-progress, o a in-progress si su
     * estado es paused. Caso contrario (pending o finished) genera un error
     * informando la causa específica del mismo
     */
    public void togglePause() {
        estado.togglePause(this);
    }

    /**
     * Pasa el ToDoItem a finished (siempre y cuando su estado actual sea
     * in-progress o pausada, si se encuentra en otro estado, no hace nada)
     */
    public void finish() {
        estado.finish(this);
        fin = LocalDateTime.now();
    }

    /**
     * Retorna el tiempo que transcurrió desde que se inició la tarea (start)
     * hasta que se finalizó. En caso de que no esté finalizada, el tiempo que
     * haya transcurrido hasta el momento actual. Si la tarea no se inició,
     * genera un error informando la causa específica del mismo.
     */
    public Duration workedTime() {
        return estado.workedTime(this);
    }

    /**
     * Agrega un comentario a la tarea siempre y cuando no haya finalizado. Caso
     * contrario no hace nada."
     */
    public void addComment(String comment) {
        estado.addComment(this, comment);
    }

    /**
     * Cambia el estado del ToDoItem a <nuevoEstado>
     */
    public void cambiarEstado(Estado nuevoEstado) {
        estado = nuevoEstado;
    }

    public void agregarComentario(String comment) {
        comentarios.add(comment);
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public Duration getDuracionTrabajada(){
        return Duration.between(comienzo, fin);
    }

    public String getEstado() {
        return estado.getNombre();
    }
}