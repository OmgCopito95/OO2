public class Pasante extends Empleado {

    private int cantidadExamenes;

    // -------------------- CONSTRUCTORES -------------------- //

    public Pasante() {
    }

    /**
     * 
     * @param cantidadExamenes
     * @param casado
     * @param cantidadHijos
     * @param sueldo
     */
    public Pasante(int cantidadExamenes, boolean casado, int cantidadHijos) {
        super(casado, cantidadHijos);
        this.cantidadExamenes = cantidadExamenes;
    }

    // ----------------- METODOS ABSTRACTOS ----------------- //

    @Override
    public float calcularSueldoBasico() {
        // $20000
        return 20000;
    }

    @Override
    public float calcularSueldoAdicional() {
        // $2000 por examen que rindio
        return this.getCantidadExamenes() * 2000;
    }

    // ----------------- GETTERS Y SETTERS ----------------- //

    public int getCantidadExamenes() {
        return cantidadExamenes;
    }

    public void setCantidadExamenes(int cantidadExamenes) {
        this.cantidadExamenes = cantidadExamenes;
    }

    public String toString() {
        return super.toString() + "tipo = pasante," + " cantidadExamenes = " + cantidadExamenes;
    }
}
