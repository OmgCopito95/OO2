public class g4Adapter implements Connection{
    
    private g4Connection g4;

    public g4Adapter(){
        this.g4 = new g4Connection("4G");
    }

    @Override
    public String sendData(String data, Integer crc) {
        // System.out.println("Adaptando g4Connection a Connection");
        return g4.transmit(data, crc);
    }

    @Override
    public String pict() {
        return this.g4.getPict();
    }
}
