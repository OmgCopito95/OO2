import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

public class TestProxy {

    private DatabaseAccess database;
    private ProtectionProxy proxy;

    @Before
    public void setUp() throws Exception {
        this.database = new DatabaseRealAccess();
        this.proxy = new ProtectionProxy(this.database);

    }

    @Test
    public void testNoLogueadoProxy(){
        assertEquals(null, this.proxy.getSearchResults("select * from comics where id=1"));
        assertEquals(-1, this.proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
    }

    @Test
    public void testGetSearchResults() {
        this.proxy.loguearse();
        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.proxy.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.proxy.getSearchResults("select * from comics where id=10"));
    }

    @Test
    public void testInsertNewRow() {
        this.proxy.loguearse();
        assertEquals(3, this.proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(Arrays.asList("Patoruzú", "La flor"), this.proxy.getSearchResults("select * from comics where id=3"));
    }
}