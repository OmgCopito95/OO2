public class DecoratorTamanio extends DecoratorFileOO2{

    public DecoratorTamanio(FileOO2 fileOO2) {
        super(fileOO2);
    }

    @Override
    public String print() {
        return this.getFileOO2().getTamanio() + " bytes";
    }

    
}
