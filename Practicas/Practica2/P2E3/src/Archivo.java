import java.time.LocalDate;

public class Archivo extends Fichero{

    public Archivo(String nombre, LocalDate fecha, int tamano) {
        super(nombre, fecha, tamano);
    }

    @Override
    public boolean esArchivo() {
        return false;
    }
    
    @Override
    public int tamanoTotalOcupado() {
        return this.getTamano();
    }

    @Override
    public Archivo archivoMasGrande() {
        return this;
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this;
    }
    

}