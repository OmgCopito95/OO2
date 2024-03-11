import java.time.LocalDate;

public abstract class Fichero {

    private String nombre;
    private LocalDate fecha;
    private int tamano;
    
    
    public Fichero(String nombre, LocalDate fecha, int tamano) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getTamano() { 
        return tamano;
    }

    public abstract boolean esArchivo();
    public abstract int tamanoTotalOcupado();
    public abstract Archivo archivoMasGrande();
    public abstract Archivo archivoMasNuevo();
}
