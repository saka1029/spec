package saka1029.spec;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestList {

    static final Int ONE = Int.of(1), TWO = Int.of(2);
    @Test
    public void testEquals() {
        assertEquals(List.NIL, Cons.list());
        assertEquals(Cons.list(ONE), Cons.list(ONE));
        assertEquals(Cons.list(ONE, TWO), Cons.list(ONE, TWO));
    }

    @Test
    public void testToString() {
        assertEquals("()", List.NIL.toString());
        assertEquals("()", Cons.list().toString());
        assertEquals("(1)", Cons.list(ONE).toString());
        assertEquals("(1 2)", Cons.list(ONE, TWO).toString());
    }

    @Test
    public void testArray() {
        assertEquals(Cons.list(ONE, TWO), Array.list(ONE, TWO));
        assertEquals(Cons.list(ONE, TWO), Cons.of(ONE, Array.list(TWO)));
    }

}
