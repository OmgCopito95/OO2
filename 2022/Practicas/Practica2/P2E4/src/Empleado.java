public abstract class Empleado {

    private boolean casado; //solo lo usa temporario y planta, lo pongo aca?
    private int cantidadHijos;
    private float sueldo;

    // -------------------- CONSTRUCTORES -------------------- //
    public Empleado() {
    }

    public Empleado(boolean casado, int cantidadHijos) {
        this.casado = casado;
        this.cantidadHijos = cantidadHijos;
    }

    // ----------------- METODOS ABSTRACTOS ----------------- //
   
    public abstract float calcularSueldoBasico();

    public abstract float calcularSueldoAdicional();


    public float calcularDescuentos() {
        // 13% del sueldo basico 5% del sueldo adicional
        return (this.calcularSueldoBasico() * 0.13f) + (this.calcularSueldoAdicional() * 0.05f); // TEMPLATE METHOD
    }

    public float sueldo() {
        // ----- CALCULO EL SUELDO DEL EMPLEADO SEGUN SU TIPO ----- //
        this.sueldo = this.calcularSueldoBasico() + this.calcularSueldoAdicional() - this.calcularDescuentos(); // TEMPLATE METHOD
        return this.sueldo;
    }

    // -------------------- GETTERS Y SETTERS -------------------- //

    public boolean esCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    public float getSueldo() {
        return sueldo;
    }

    public String toString() {
        return "Empleado: " + "casado = " + casado + ", cantidadHijos = " + cantidadHijos + ", sueldo = " + this.sueldo() + ", ";
    }


}
