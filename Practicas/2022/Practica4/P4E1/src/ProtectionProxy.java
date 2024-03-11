import java.util.Collection;
import java.util.List;

public class ProtectionProxy implements DatabaseAccess {

    private DatabaseAccess basededatos;
    private boolean logueado;

    // creo el proxy sin que esté logueado
    public ProtectionProxy(DatabaseAccess basededatos) {
        this.basededatos = basededatos;
        this.logueado = false;
    }

    public boolean loguearse() {
        this.logueado = true;
        return true;
    }

    private boolean estaLogueado() {
        return this.logueado;
    }

    @Override
    public Collection<String> getSearchResults(String queryString) {
        if (this.estaLogueado()) {
            return this.basededatos.getSearchResults(queryString);
        } else {
            return null;
        }
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if (this.estaLogueado()) {
            return this.basededatos.insertNewRow(rowData);
        } else {
            return -1;
        }
    }

}
