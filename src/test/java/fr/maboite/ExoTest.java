package fr.maboite;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class VoidClass {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof VoidClass; // vide est toujours égale à vide
    }
}

public class ExoTest {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("before all");
    }

    @BeforeEach
    public void beforeEach(TestInfo test) {
        System.out.println("    before each");
        System.out.println("        execution de " + test.getDisplayName());
    }

    @AfterEach
    public void afterEach() {
        System.out.println("    after each");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all");
    }

    @Test
    public void toujoursVrai() {
        assertTrue(true);
    }

    @Test
    public void toujoursFaux() {
        assertFalse(true);
    }

    @Test
    public void toujoursEgal() {
        VoidClass t1 = new VoidClass();
        VoidClass t2 = new VoidClass();
        assertEquals(t1, t2); // check value, or ref
    }

    @Test
    public void toujoursSame() {
        VoidClass t1 = new VoidClass();
        VoidClass t2 = t1;
        assertSame(t1, t2); // check ref
    }
}
