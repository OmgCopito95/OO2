public class Temporario extends Empleado {

    
    private int horasTrabajadas;


    // -------------------- CONSTRUCTORES -------------------- //

    public Temporario() {}

    /**
     * 
     * @param horasTrabajadas
     * @param casado
     * @param cantidadHijos
     * @param sueldo
     */
    public Temporario(int horasTrabajadas, boolean casado, int cantidadHijos) {
        super(casado, cantidadHijos);
        this.horasTrabajadas = horasTrabajadas;
    }


    // ----------------- METODOS ABSTRACTOS ----------------- //

    @Override
    public float calcularSueldoBasico() {
        // $20000 + cantidad de horas que trabajo * $300
        return 20000 + (this.getHorasTrabajadas() * 300);
    }

    @Override
    public float calcularSueldoAdicional() {
        // $5000 si está casado + $2000 por cada hijo
        return (this.esCasado() ? 5000 : 0) + (this.getCantidadHijos() * 2000);
    }


    // ----------------- GETTERS Y SETTERS ----------------- //

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
}