package saka1029.spec;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestScanner {

    @Test
    public void testList() {
        Scanner s = Scanner.of("(123 -2 + 'a +a [321])");
        assertEquals(TokenType.LP, s.get());
        assertEquals(TokenType.INT, s.get());
        assertEquals(Int.of(123), s.intValue());
        assertEquals(TokenType.INT, s.get());
        assertEquals(Int.of(-2), s.intValue());
        assertEquals(TokenType.SYMBOL, s.get());
        assertEquals(Symbol.of("+"), s.symbolValue());
        assertEquals(TokenType.SYMBOL, s.get());
        assertEquals(Symbol.of("'"), s.symbolValue());
        assertEquals(TokenType.SYMBOL, s.get());
        assertEquals(Symbol.of("a"), s.symbolValue());
        assertEquals(TokenType.SYMBOL, s.get());
        assertEquals(Symbol.of("+a"), s.symbolValue());
        assertEquals(TokenType.LB, s.get());
        assertEquals(TokenType.INT, s.get());
        assertEquals(Int.of(321), s.intValue());
        assertEquals(TokenType.RB, s.get());
        assertEquals(TokenType.RP, s.get());
        assertEquals(TokenType.END, s.get());
    }

}
