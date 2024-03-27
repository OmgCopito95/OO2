public class DecoratorName extends DecoratorFileOO2 {

    public DecoratorName(FileOO2 fileOO2) {
        super(fileOO2);
    }

    @Override
    public String print() {
        return this.getFileOO2().getNombre();
    }

}
