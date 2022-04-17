public class WifiConn implements Connection {

    private String pict;

    public WifiConn() {
        this.pict = "Wifi";
    }

    @Override
    public String sendData(String data, Integer crc) {
        return "transmitiendo datos wifi";
    }

    @Override
    public String pict() {
        return this.pict;
    }

}
