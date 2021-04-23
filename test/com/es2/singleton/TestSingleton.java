package com.es2.singleton;

import org.junit.jupiter.api.*;

import static org.junit.Assert.*;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class TestSingleton {

    @BeforeAll
    public static void setUpBeforeAllTests(){
    }

    @BeforeEach
    public void setUp(){
        HashMap h = new HashMap();
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