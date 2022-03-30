import java.time.LocalDate;

public class Archivo {

    private String nombre;
    private LocalDate fecha;
    private int tamano;

    /**
     * Crea un nuevo archivo con nombre <nombre>, de <tamano> tamano
     * y en la fecha <fecha>.
     */
    public Archivo(String nombre, LocalDate fecha, int tamano) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tamano = tamano;
    }

    /**
     * Retorna el nombre del archivo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la fecha de creacion del archivo.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Retorna el tamaño del archivo.
     */
    public int getTamano() {
        return tamano;
    }
}