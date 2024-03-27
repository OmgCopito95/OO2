public class DecoratorExtension extends DecoratorFileOO2{

    public DecoratorExtension(FileOO2 fileOO2) {
        super(fileOO2);
    }

    @Override
    public String print() {
        return this.getFileOO2().getExtension();
    }

    
}
