public class g4Connection {

    private String symb;

    public g4Connection(String symb) {
        this.symb = symb;
    }

    public String getSymb() {
        return symb;
    }

    public void setSymb(String symb) {
        this.symb = symb;
    }

    public String getPict() {
        return this.getSymb();
    }

    public String transmit(String data, int crc) {
        return "transmitiendo datos 4g";
    }
    
}
