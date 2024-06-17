package saka1029.spec;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestList {

    @Test
    public void testEquals() {
        assertEquals(List.NIL, Cons.list());
        assertEquals(Cons.list(Int.of(1)), Cons.list(Int.of(1)));
        assertEquals(Cons.list(Int.of(1), Int.of(2)), Cons.list(Int.of(1), Int.of(2)));
    }

    @Test
    public void testToString() {
        assertEquals("()", List.NIL.toString());
        assertEquals("()", Cons.list().toString());
        assertEquals("(1)", Cons.list(Int.of(1)).toString());
        assertEquals("(1 2)", Cons.list(Int.of(1), Int.of(2)).toString());
    }

}
