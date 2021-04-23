package com.es2.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import static org.junit.Assert.*;
import java.lang.reflect.Modifier;

public class RegistryTest {

    @Before
    public void setUp() throws Exception {
    }

    @AfterAll
    static void tearDown() {
        End e = new End();
    }

    @Test
    public void test_setPath() {
        Registry.getInstance().setPath("test");
        String path = Registry.getInstance().getPath();
        assertEquals("test", path);
    }

    @Test
    public void test_setConnectionString() {
        Registry.getInstance().setConnectionString("test");
        String connString = Registry.getInstance().getConnectionString();
        assertEquals("test", connString);
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