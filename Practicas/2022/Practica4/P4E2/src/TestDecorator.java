import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestDecorator {

    FileOO2 archivo;

    @Before
    public void setUp() throws Exception {
        //creo un Archivo
        archivo = new Archivo("nombre", ".txt", 10, "12/12/2022", "12/12/2022", "rwxrwxrwx");
    }

    @Test
    public void testDecorator1() {
        // nombre - extensión

        // creo un decorador de extension
        DecoratorExtension decoradorExtension = new DecoratorExtension(archivo);
        //creo un decorador de nombre
        DecoratorName decoradorNombre = new DecoratorName(decoradorExtension);

        assertEquals("nombre - .txt", decoradorNombre.prettyPrint());
    }

    @Test
    public void testDecorator2(){
        // nombre - extension - fecha de creación
        
        //creo un decorador de fecha de creacion
        DecoratorFechaCreacion decoradorFechaCreacion = new DecoratorFechaCreacion(archivo);
        //creo un decorador de extension
        DecoratorExtension decoradorExtension = new DecoratorExtension(decoradorFechaCreacion);
        //creo un decorador de nombre
        DecoratorName decoradorNombre = new DecoratorName(decoradorExtension);

        assertEquals("nombre - .txt - 12/12/2022", decoradorNombre.prettyPrint());
    }

    @Test
    public void testDecorator3(){
        //permisos - nombre - extension - tamanio

        //creo un decorador de tamanio
        DecoratorTamanio decoradorTamanio = new DecoratorTamanio(archivo);
        //creo un decorador de extension
        DecoratorExtension decoradorExtension = new DecoratorExtension(decoradorTamanio);
        //creo un decorador de nombre
        DecoratorName decoradorNombre = new DecoratorName(decoradorExtension);
        //creo un decorador de permisos
        DecoratorPermisos decoradorPermisos = new DecoratorPermisos(decoradorNombre);

        assertEquals("rwxrwxrwx - nombre - .txt - 10 bytes", decoradorPermisos.prettyPrint());
    }

    
}
