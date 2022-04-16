public class Dispositivo {

    private Connection connection;
    private Display display;
    private Ringer ringer;
    private CRC16_Calculator crcCalculator;

    public Dispositivo() {
        this.display = new Display();
        this.ringer = new Ringer();
        this.crcCalculator = new CRC16_Calculator(); //lo dejo para probar el adapter
    }

    // // ------ Métodos de la interfaz Connection ------
    // public void usar4G() {
    //     this.connection = new g4Adapter();
    // }

    // public void usarWifiConnection() {
    //     this.connection = new WifiConn();
    // }
    // // ----------------------------------------------- 


    public String send(String data) {
        // calculo el CRC
        Integer crc = this.crcCalculator.crcFor(data);

        // envio los datos
        return this.connection.sendData(data, crc);
    }

    public String conectarCon(Connection c) {
        // emite ring
        this.ringer.ring();
        this.connection = c; //cambia la conexion
        
        //muestra en el display la conexion
        return this.display.showBanner(this.connection.pict());
    }

    public void configurarCRC() {

    }
}
