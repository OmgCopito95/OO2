import java.util.zip.CRC32;

public class CRC32_Calculator implements CRC_Calculator {

    @Override
    public Integer crcFor(String datos) {
        CRC32 crc = new CRC32();
        crc.update(datos.getBytes());
        return (int) crc.getValue();
    }

}

