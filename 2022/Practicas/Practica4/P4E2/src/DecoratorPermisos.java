public class DecoratorPermisos extends DecoratorFileOO2{

    public DecoratorPermisos(FileOO2 fileOO2) {
        super(fileOO2);
    }

    @Override
    public String print() {
        return this.getFileOO2().getPermisos();
    }
    
}
