import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

// test biblioteca

public class BibliotecaTest {

    private Biblioteca biblioteca, b1, b2, b3;;
    private Socio s1, s2;

    @Before
    public void setUp() {
        biblioteca = new Biblioteca();

        biblioteca.setExporter(new JSONSimpleAdapter());
        
        b1 = new Biblioteca();
        b2 = new Biblioteca();
        b3 = new Biblioteca();
        s1 = new Socio("Arya Stark", "needle@stark.com", "5234-5");
        s2 = new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2");
        biblioteca.agregarSocio(s1);
        biblioteca.agregarSocio(s2);
    }

    @Test
    public void test() {

        // exporta socios
        String json = biblioteca.exportarSocios();

        // elimina llaves corchetes
        json = json.replaceAll("\\[", "");
        json = json.replaceAll("\\{", "");
        json = json.replaceAll("\\]", "");
        json = json.replaceAll("\\}", "");

        // elimina los espacios antes de una comilla
        json = json.replaceAll("\"\\s+", "\"");
        // elimina los espacios despues de una comilla
        json = json.replaceAll("\\s+\"", "\"");

        // arma un array con los datos del socio
        String[] datos = json.split(",");

        //por cada elemento del array se queda con el segundo texto entre comillas
        for (int i = 0; i < datos.length; i++) {
            datos[i] = datos[i].replaceAll("\"", "").split(":")[1];
        }

        // System.out.println(datos[0]);

        //socio 1
        assertEquals(datos[1], s1.getNombre());
        assertEquals(datos[2], s1.getEmail());
        assertEquals(datos[0], s1.getLegajo());

        //socio 2
        assertEquals(datos[4], s2.getNombre());
        assertEquals(datos[5], s2.getEmail());
        assertEquals(datos[3], s2.getLegajo());


    }

    @Test
    public void testExportarSocios() {
        b1.agregarSocio(s1);
        b1.agregarSocio(s2);
        b2.agregarSocio(s1);

        String json_de_b1 = b1.exportarSocios();
        String json_de_b2 = b2.exportarSocios();

        // elimina todos los tabs
        json_de_b1 = json_de_b1.replaceAll("	", "");
        json_de_b2 = json_de_b2.replaceAll("	", "");

        // elimina todos los saltos de linea
        json_de_b1 = json_de_b1.replaceAll("\r\n", "");
        json_de_b2 = json_de_b2.replaceAll("\r\n", "");

        // elimina todos los espacios despues de ": "
        json_de_b1 = json_de_b1.replaceAll(": ", ":");
        json_de_b2 = json_de_b2.replaceAll(": ", ":");


        assertEquals(151, json_de_b1.length());
        assertEquals(true, json_de_b1.contains("\"nombre\":\"Arya Stark\""));
        assertEquals(true, json_de_b1.contains("\"email\":\"needle@stark.com\""));
        assertEquals(true, json_de_b1.contains("\"legajo\":\"5234-5\""));
        assertEquals(70, json_de_b2.length());
        assertEquals("[]", b3.exportarSocios());
    }
}