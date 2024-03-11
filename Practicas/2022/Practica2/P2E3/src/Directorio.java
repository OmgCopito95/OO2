import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directorio extends Fichero {

    private List<Fichero> ficheros;

    public Directorio(String nombre, LocalDate fecha) {
        super(nombre, fecha, 32);
        this.ficheros = new ArrayList<Fichero>();
    }

    public void agregar(Fichero fichero) {
        ficheros.add(fichero);
    }

    /**
     * Retorna el espacio total ocupado, incluyendo su contenido.
     */
    public int tamanoTotalOcupado() {
        int total = this.getTamano();
        if (this.esArchivo()) {
            for (Fichero fichero : ficheros) {
                total += fichero.getTamano();
            }
        } else {
            if (!this.esArchivo()) {
                for (Fichero fichero : ficheros) {
                    total += fichero.tamanoTotalOcupado();
                }
            }
        }
        return total;
    }

    /**
     * Retorna el archivo con mayor cantidad de bytes en cualquier nivel del
     * filesystem contenido por directorio receptor
     */
    public Archivo archivoMasGrande() {
        Archivo archivoMasGrandeReturn = null;
        int tamanoArchivoMasGrande = this.getTamano();

        if (this.esArchivo()) {
            return archivoMasGrandeReturn;
        } else {
            // si es un directorio, busco en sus ficheros
            for (Fichero fichero : ficheros) {
                if (fichero.esArchivo()) {
                    if (fichero.getTamano() > tamanoArchivoMasGrande) {
                        archivoMasGrandeReturn = (Archivo) fichero;
                        tamanoArchivoMasGrande = fichero.getTamano();
                    }
                } else {
                    // si es un directorio, busco en sus ficheros
                    Archivo archivoMasGrande = fichero.archivoMasGrande();
                    if (archivoMasGrande != null) {
                        if (archivoMasGrande.getTamano() > tamanoArchivoMasGrande) {
                            archivoMasGrandeReturn = archivoMasGrande;
                            tamanoArchivoMasGrande = archivoMasGrande.getTamano();
                        }
                    }
                }
            }

        }
        return archivoMasGrandeReturn;
    }

    /**
     * Retorna el archivo con fecha de creación más reciente en cualquier nivel
     * del filesystem contenido por directorio receptor.
     */
    public Archivo archivoMasNuevo() {
        Archivo archivoMasNuevoReturn = null;
        LocalDate fechaArchivoMasNuevo = this.getFecha();

        if (this.esArchivo()) {
            return archivoMasNuevoReturn;
        } else {
            // si es un directorio, busco en sus ficheros
            for (Fichero fichero : ficheros) {
                if (fichero.esArchivo()) {
                    if (fichero.getFecha().isAfter(fechaArchivoMasNuevo)) {
                        archivoMasNuevoReturn = (Archivo) fichero;
                        fechaArchivoMasNuevo = fichero.getFecha();
                    }
                } else {
                    // si es un directorio, busco en sus ficheros
                    Archivo archivoMasNuevo = fichero.archivoMasNuevo();
                    if (archivoMasNuevo != null) {
                        if (archivoMasNuevo.getFecha().isAfter(fechaArchivoMasNuevo)) {
                            archivoMasNuevoReturn = archivoMasNuevo;
                            fechaArchivoMasNuevo = archivoMasNuevo.getFecha();
                        }
                    }
                }
            }

        }
        return archivoMasNuevoReturn;

    }

    // -------- METODOS ABSTRACTOS -------- //

    @Override
    public boolean esArchivo() {
        return false;
    }

}