import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner14;

public class Directorio {

    private String nombre;
    private LocalDate fecha;
    private String contenido;
    private int tamano = 32;

    // tiene una lista de archivos
    private List<Archivo> archivos;

    // tiene una lista de directorios
    private List<Directorio> directorios;

    /**
     * Crea un nuevo Directorio con nombre <nombre> y en la fecha <fecha>.
     */
    public Directorio(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        archivos = new ArrayList<Archivo>(); // crea la lista de archivos vacia
        directorios = new ArrayList<Directorio>(); // crea la lista de directorios vacia
    }

    /**
     * Agrega un archivo al directorio.
     * 
     * @param archivo
     */
    public void agregar(Archivo archivo) {
        archivos.add(archivo);
    }

    /**
     * Agrega un directorio al directorio.
     * 
     * @param directorio
     */
    public void agregar(Directorio directorio) {
        directorios.add(directorio);
    }

    public int getTamanoDefault() {
        return this.tamano;
    }

    /**
     * Retorna el espacio total ocupado, incluyendo su contenido.
     */
    public int tamanoTotalOcupado() {
        int suma = this.getTamanoDefault();

        if ((!tieneArchivos()) && (!tieneDirectorios())) { // no tiene archivos ni directorios
            System.out.println("entro1");
            return suma; // seria un caso base
        } else {
            if ((!tieneArchivos()) && (tieneDirectorios())) { // no tiene archivos pero si directorios
                for (Directorio d : this.getDirectorios()) {
                    System.out.println("entro2");
                    suma += d.tamanoTotalOcupado(); // llamo a la recursion
                }
            } else {
                if (tieneArchivos() && (!tieneDirectorios())) { // si tiene archivos pero no directorios
                    for (Archivo a : this.getArchivos()) {
                        System.out.println("entro3");
                        suma += a.getTamano(); // seria como un caso base porque "llegue a una hoja"
                    }
                } else {
                    if (tieneArchivos() && (tieneDirectorios())) { // si tiene archivos y directorios
                        for (Archivo a : this.getArchivos()) {
                            System.out.println("entro4");
                            suma += a.getTamano();
                        }
                        for (Directorio d : this.getDirectorios()) {
                            System.out.println("entro5");
                            suma += d.tamanoTotalOcupado(); // llamo a la recursion
                        }
                    }
                }
            }
        }
        return suma;
    }

    private boolean tieneArchivos() {
        return this.getArchivos().size() != 0;
    }

    private boolean tieneDirectorios() {
        return this.getDirectorios().size() != 0;
    }

    public List<Archivo> getArchivos() {
        return this.archivos;
    }

    public List<Directorio> getDirectorios() {
        return this.directorios;
    }

    /**
     * Retorna el archivo con mayor cantidad de bytes en cualquier nivel del
     * filesystem contenido por directorio receptor
     */
    public Archivo archivoMasGrande() {
        Archivo archivoMasGrande = null;
        int tamanoArchivoMasGrande = 0;

        if ((!tieneArchivos()) && (!tieneDirectorios())) { // no tiene archivos ni directorios
            // System.out.println("entro1");
            return archivoMasGrande; // seria un caso base
        } else {
            if ((!tieneArchivos()) && (tieneDirectorios())) { // no tiene archivos pero si directorios
                for (Directorio d : this.getDirectorios()) {
                    // System.out.println("entro2");
                    return d.archivoMasGrande(); // llamo a la recursion
                }
            } else {
                if (tieneArchivos() && (!tieneDirectorios())) { // si tiene archivos pero no directorios
                    for (Archivo a : this.getArchivos()) {
                        // System.out.println("entro3");
                        if (a.getTamano() > tamanoArchivoMasGrande) {
                            tamanoArchivoMasGrande = a.getTamano();
                            archivoMasGrande = a;
                        }
                    }
                } else {
                    if (tieneArchivos() && (tieneDirectorios())) { // si tiene archivos y directorios
                        for (Archivo a : this.getArchivos()) {
                            // System.out.println("entro4");
                            if (a.getTamano() > tamanoArchivoMasGrande) {
                                tamanoArchivoMasGrande = a.getTamano();
                                archivoMasGrande = a;
                            }
                        }
                        for (Directorio d : this.getDirectorios()) {
                            // System.out.println("entro5");
                            return d.archivoMasGrande(); // llamo a la recursion
                        }
                    }
                }
            }
        }
        return archivoMasGrande;

    }

    /**
     * Retorna el archivo con fecha de creación más reciente en cualquier nivel
     * del filesystem contenido por directorio receptor.
     */
    public Archivo archivoMasNuevo() {
        Archivo archivoMasNuevo = null;
        LocalDate fechaArchivoMasNuevo = null;

        if ((!tieneArchivos()) && (!tieneDirectorios())) { // no tiene archivos ni directorios
            System.out.println("entro1");
            return archivoMasNuevo; // seria un caso base
        } else {
            if ((!tieneArchivos()) && (tieneDirectorios())) { // no tiene archivos pero si directorios
                for (Directorio d : this.getDirectorios()) {
                    System.out.println("entro2");
                    return d.archivoMasNuevo(); // llamo a la recursion
                }
            } else {
                if (tieneArchivos() && (!tieneDirectorios())) { // si tiene archivos pero no directorios
                    for (Archivo a : this.getArchivos()) {
                        System.out.println("entro3");
                        // me fijo si es la primera vez que entro
                        if (fechaArchivoMasNuevo == null) { //me quedo con la fecha del primer archivo
                            fechaArchivoMasNuevo = a.getFecha();
                            archivoMasNuevo = a;
                        } else {
                            if (a.getFecha().isAfter(fechaArchivoMasNuevo)) {
                                fechaArchivoMasNuevo = a.getFecha();
                                archivoMasNuevo = a;
                            }
                        }
                    }
                } else {
                    if (tieneArchivos() && (tieneDirectorios())) { // si tiene archivos y directorios
                        for (Archivo a : this.getArchivos()) {
                            System.out.println("entro4");
                            // me fijo si es la primera vez que entro
                            if (fechaArchivoMasNuevo == null) {
                                fechaArchivoMasNuevo = a.getFecha(); 
                                archivoMasNuevo = a;
                            } else {
                                if (a.getFecha().isAfter(fechaArchivoMasNuevo)) {
                                    fechaArchivoMasNuevo = a.getFecha();
                                    archivoMasNuevo = a;
                                }
                            }
                        }
                        for (Directorio d : this.getDirectorios()) {
                            System.out.println("entro5");
                            return d.archivoMasNuevo(); // llamo a la recursion
                        }
                    }
                }
            }
        }
        return archivoMasNuevo;

    }
}