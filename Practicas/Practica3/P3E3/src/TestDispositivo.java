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
        d.configurarCRC(new CRC32_Calculator());

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
        assertEquals("CRC configurado", d.configurarCRC(new CRC16_Calculator()));
        assertEquals("CRC configurado", d.configurarCRC(new CRC32_Calculator()));
    }


    
}
