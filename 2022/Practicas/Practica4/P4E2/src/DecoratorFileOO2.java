public abstract class DecoratorFileOO2 implements FileOO2 {

    private FileOO2 fileOO2;

    public DecoratorFileOO2(FileOO2 fileOO2) {
        this.fileOO2 = fileOO2;
    }

    public FileOO2 getFileOO2() {
        return fileOO2;
    }

    @Override
    public String prettyPrint() {
        if(this.fileOO2.prettyPrint() != ""){
            return this.print() + " - " + this.fileOO2.prettyPrint();
        }
        return this.print();
    }

    public abstract String print(); //lo implementan las clases concretas decoradores


    // con estos metodos los va a buscar al archivo 

    @Override
    public String getNombre() { 
        return fileOO2.getNombre();
    }

    @Override
    public String getExtension() {
        return fileOO2.getExtension();
    }

    @Override
    public int getTamanio() {
        return fileOO2.getTamanio();
    }

    @Override
    public String getFechaCreacion() {
        return fileOO2.getFechaCreacion();
    }

    @Override
    public String getFechaModificacion() {
        return fileOO2.getFechaModificacion();
    }

    @Override
    public String getPermisos() {
        return fileOO2.getPermisos();
    }

    
}
