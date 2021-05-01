import com.es2.decorator.*;
import com.es2.singleton.End;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class TestDecorator {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpBeforeAllTests() {
    }

    @BeforeEach
    public void setUp(){}

    @AfterAll
    static void tearDown() {
        End e = new End();
    }

    @BeforeAll
    public static void setUpStreams() throws FileNotFoundException {
        String outContent = null;
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.setOut(System.out);
        End e = new End();
    }


    @Test
    public void testRightAuthWithoutDecorators() throws AuthException, IOException {
        AuthInterface auth = new Auth();
        auth.auth("admin", "admin");
    }

    // Password errada
    @Test(expected = AuthException.class)
    public void testWrongAuthWithoutDecorators() throws AuthException, IOException {
        AuthInterface auth = new Auth();
        auth.auth("admin", "notadmin");
    }

    // Auth Correta, mas admin é uma palavra comum
    @Test(expected = AuthException.class)
    public void testRightAuthWithCommonWordsDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Auth());
        auth.auth("admin", "adminnn");
    }

    // Auth incorreta, mas palavra não é comum
    @Test(expected = AuthException.class)
    public void testWrongAuthWithCommonWordsDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Auth());
        auth.auth("admin", "ola");
    }

    // Auth correta com logging decorator
    @Test
    public void testRightAuthWithLoggingDecorator() throws AuthException, IOException {
        AuthInterface auth = new Logging(new Auth());
        auth.auth("admin", "admin");
    }

    // Auth incorreta com logging decorator
    @Test(expected = AuthException.class)
    public void testWrongAuthWithLoggingDecorator() throws AuthException, IOException {
        AuthInterface auth = new Logging(new Auth());
        auth.auth("admin", "notadmin");
    }

    // Auth correta, com todos decorators. Dá error porque admin é uma palavra comum
    @Test(expected = AuthException.class)
    public void testRightAuthWithAllDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Logging(new Auth()));
        auth.auth("admin", "adminnn");
    }

    // Auth incorreta, mas com palavra não comum
    @Test(expected = AuthException.class)
    public void testWrongAuthWithAllDecorator() throws AuthException, IOException {
        AuthInterface auth = new CommonWordsValidator(new Logging(new Auth()));
        auth.auth("admin", "ola");
    }
}