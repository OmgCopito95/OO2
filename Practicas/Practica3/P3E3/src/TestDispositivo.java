import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestDispositivo {

    Dispositivo d;

    @Before
    public void setUp(){
        d = new Dispositivo();        
    }

    @Test
    public void testSend() {
        d.conectarCon(new WifiConn());
        assertEquals("transmitiendo datos wifi", d.send("hola"));
        d.conectarCon(new g4Adapter());
        assertEquals("transmitiendo datos 4g", d.send("hola"));
    }

    @Test
    public void testConectarCon() {
        assertEquals("Wifi", d.conectarCon(new WifiConn()));
        assertEquals("4G", d.conectarCon(new g4Adapter()));
    }

    @Test
    public void testConfigurarCRC() {
        // d.configurarCRC();
    }


    
}
