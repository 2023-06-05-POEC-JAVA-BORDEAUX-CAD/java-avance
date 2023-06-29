package fr.maboite;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class VoidClass {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof VoidClass; // vide est toujours égale à vide
    }
}

public class ExoTest {
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
