public class DecoratorFechaCreacion extends DecoratorFileOO2{

    public DecoratorFechaCreacion(FileOO2 fileOO2) {
        super(fileOO2);
    }

    @Override
    public String print() {
        return this.getFileOO2().getFechaCreacion();
    }
}
