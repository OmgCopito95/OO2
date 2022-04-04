public class main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setExporter(new JSONSimpleAdapter());

        Socio s1 = new Socio("Arya Stark", "needle@stark.com", "5234-5");
        Socio s2 = new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2");
        biblioteca.agregarSocio(s1);
        biblioteca.agregarSocio(s2);

        System.out.println(biblioteca.exportarSocios());


    }

    
}
