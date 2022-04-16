public class prueba {

    public static void main(String[] args) {
        Dispositivo d = new Dispositivo();
        System.out.println(d.conectarCon(new WifiConn()));
        System.out.println(d.send("hola"));

        System.out.println(d.conectarCon(new g4Adapter()));
        System.out.println(d.send("hola"));
    }
    
    
}
