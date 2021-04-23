package com.es2.singleton;

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
    public void testSetPath() {
        Registry.getInstance().setPath("");
        String path = Registry.getInstance().getPath();
        assertEquals("", path);
    }

    @Test
    @DisplayName("Test Set Connection String")
    public void test_setConnectionString() {
        Registry.getInstance().setConnectionString("");
        String connString = Registry.getInstance().getConnectionString();
        assertEquals("", connString);
    }

    @Test
    public void test_setPathParams() {
        Registry.getInstance().setPath("");
        String path = Registry.getInstance().getPath();
        assertEquals("", path);
    }

    @Test
    public void test_setConnectionStringParams() {
        Registry.getInstance().setConnectionString("");
        String connString = Registry.getInstance().getConnectionString();
        assertEquals("", connString);
    }

    @Test
    public void test_Singleton() {
        if(!Modifier.isPublic(Registry.class.getModifiers()))
            fail("Not private");
    }
}