package saka1029.spec;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestList {

    static final Int ONE = Int.of(1), TWO = Int.of(2);
    @Test
    public void testEquals() {
        assertEquals(List.NIL, Cons.of());
        assertEquals(Cons.of(ONE), Cons.of(ONE));
        assertEquals(Cons.of(ONE, TWO), Cons.of(ONE, TWO));
    }

    @Test
    public void testToString() {
        assertEquals("()", List.NIL.toString());
        assertEquals("()", Cons.of().toString());
        assertEquals("(1)", Cons.of(ONE).toString());
        assertEquals("(1 2)", Cons.of(ONE, TWO).toString());
    }

    @Test
    public void testArray() {
        assertEquals(Cons.of(ONE, TWO), Array.list(ONE, TWO));
        assertEquals(Cons.of(ONE, TWO), Cons.of(ONE, Array.list(TWO)));
    }

}
