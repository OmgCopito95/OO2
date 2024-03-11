import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestEmpleado {

    Empleado empleado1;
    Empleado empleado2;
    Empleado empleado3;

    @Before
    public void setUp() throws Exception {
        // creo 3 empleados de diferentes tipos
        empleado1 = new Pasante(15, true, 7); // cantidadExamenes = 15, casado = true, cantidadHijos = 7
        empleado2 = new Planta(10, false, 3); // antiguedad = 10, casado = false, cantidadHijos = 3
        empleado3 = new Temporario(20, true, 2); // horasTrabajadas = 20, casado = true, cantidadHijos = 2
    }

    @Test
    public void empleadosCreadosCorrectamente() {
        // verifico que se crearon correctamente

        assertEquals(true, empleado1.esCasado());
        assertEquals(7, empleado1.getCantidadHijos());
        // assertEquals(15, empleado1.getCantidadExamenes());

        assertEquals(false, empleado2.esCasado());
        assertEquals(3, empleado2.getCantidadHijos());
        // assertEquals(10, empleado2.getAntiguedad());

        assertEquals(true, empleado3.esCasado());
        assertEquals(2, empleado3.getCantidadHijos());
        // assertEquals(20, empleado3.getHorasTrabajadas());

    }

    @Test
    public void sueldo(){
        // verifico que los sueldos se calculan correctamente
        assertEquals(45900, empleado1.sueldo(), 0.01); //20000+30000  - 13% de 20000 - 5% de 30000 = 45900
        assertEquals(68200, empleado2.sueldo(), 0.01); 
        assertEquals(31170, empleado3.sueldo(), 0.01); 
    }

}
