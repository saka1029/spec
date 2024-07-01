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
        assertEquals(List.NIL, Array.of());
        assertEquals(Cons.of(ONE), Array.of(ONE));
        assertEquals(Cons.of(ONE, TWO), Array.of(ONE, TWO));
    }

    @Test
    public void testToString() {
        assertEquals("()", List.NIL.toString());
        assertEquals("()", Cons.of().toString());
        assertEquals("(1)", Cons.of(ONE).toString());
        assertEquals("(1 2)", Cons.of(ONE, TWO).toString());
        assertEquals("()", Array.of().toString());
        assertEquals("(1)", Array.of(ONE).toString());
        assertEquals("(1 2)", Array.of(ONE, TWO).toString());
    }

    @Test
    public void testCar() {
        assertEquals(ONE, Cons.of(ONE).car());
        assertEquals(ONE, Cons.of(ONE, TWO).car());
        assertEquals(ONE, Array.of(ONE).car());
        assertEquals(ONE, Array.of(ONE, TWO).car());
    }

    @Test
    public void testCdr() {
        assertEquals(List.NIL, Cons.of(ONE).cdr());
        assertEquals(Cons.of(TWO), Cons.of(ONE, TWO).cdr());
        assertEquals(List.NIL, Array.of(ONE).cdr());
        assertEquals(Cons.of(TWO), Array.of(ONE, TWO).cdr());
    }

    @Test
    public void testCons() {
        assertEquals(Cons.of(ONE, TWO), List.NIL.cons(TWO).cons(ONE));
        assertEquals(Array.of(ONE, TWO), List.NIL.cons(TWO).cons(ONE));
    }

}
