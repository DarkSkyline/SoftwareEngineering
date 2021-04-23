import com.es2.singleton.End;
import com.es2.singleton.Registry;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Modifier;

public class TestSingleton {

    @BeforeAll
    public static void setUpBeforeAllTests() {
    }

    @BeforeEach
    public void setUp(){}

    @AfterAll
    static void tearDown() {
        End e = new End();
    }

    @Test
    @DisplayName("Test Set Path")
    public void testPath() {
        Registry.getInstance().setPath("test");
        String path = Registry.getInstance().getPath();
        assertEquals("test", path);
    }

    @Test
    @DisplayName("Test Set Connection String")
    public void testConnectionStringNull() {
        Registry.getInstance().setConnectionString(null);
        String connString = Registry.getInstance().getConnectionString();
        assertEquals(null, connString);
    }

    @Test
    public void testPathNull() {
        Registry.getInstance().setPath(null);
        String path = Registry.getInstance().getPath();
        assertEquals(null, path);
    }

    @Test
    public void testConnectionString() {
        Registry.getInstance().setConnectionString("test");
        String connString = Registry.getInstance().getConnectionString();
        assertEquals("test", connString);
    }

    @Test
    public void test_Singleton() {
        if(!Modifier.isPublic(Registry.class.getModifiers()))
            fail("Not private");
    }
}