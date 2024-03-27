public class DecoratorFechaModificacion extends DecoratorFileOO2 {

    public DecoratorFechaModificacion(FileOO2 fileOO2) {
        super(fileOO2);
    }

    @Override
    public String print() {
        return this.getFileOO2().getFechaModificacion();
    }
    
}
