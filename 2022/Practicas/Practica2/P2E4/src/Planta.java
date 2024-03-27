public class Planta extends Empleado {

    
    private int antiguedad;
    
    // -------------------- CONSTRUCTORES -------------------- //

    public Planta(){}

    /**
     * 
     * @param antiguedad
     * @param casado
     * @param cantidadHijos
     * @param sueldo
     */
    public Planta(int antiguedad, boolean casado, int cantidadHijos) {
        super(casado, cantidadHijos);
        this.antiguedad = antiguedad;
    }

    // ----------------- METODOS ABSTRACTOS ----------------- //

    @Override
    public float calcularSueldoBasico() {
        // $50000
        return 50000;
    }

    @Override
    public float calcularSueldoAdicional() {
        // $5000 si esta casado + $2000 por cada hijo + $2000 por cada año de antiguedad
        return (this.esCasado() ? 5000 : 0) + (this.getCantidadHijos() * 2000) + (this.getAntiguedad() * 2000);
    }

    // ----------------- GETTERS Y SETTERS ----------------- //

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
