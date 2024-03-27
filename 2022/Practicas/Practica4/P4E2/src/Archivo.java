import java.time.LocalDate;

public class Archivo implements FileOO2{

    // atributos: nombre, extension, tamaño, fecha de creacion, fecha de modificacion, permisos
    private String nombre;
    private String extension;
    private int tamanio;
    private String fechaCreacion;
    private String fechaModificacion;
    private String permisos;

    // constructor
    public Archivo(String nombre, String extension, int tamanio, String fechaCreacion, String fechaModificacion, String permisos){
        this.nombre = nombre;
        this.extension = extension;
        this.tamanio = tamanio;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.permisos = permisos;
    }

    // getters
    public String getNombre(){
        return nombre;
    }

    public String getExtension(){
        return extension;
    }

    public int getTamanio(){
        return tamanio;
    }

    public String getFechaCreacion(){
        return fechaCreacion;
    }

    public String getFechaModificacion(){
        return fechaModificacion;
    }

    public String getPermisos(){
        return permisos;
    }

    @Override
    public String prettyPrint() {
        //no hace nada
        return "";
    }

}