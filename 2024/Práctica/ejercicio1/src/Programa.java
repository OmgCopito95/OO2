public class Programa {

    public static void main(String[] args) {
        Twitter t = new Twitter();
        Usuario u = new Usuario("juan");
        System.out.println(u.getScreenName());
        t.addUsuario(u);
        
    }

}
