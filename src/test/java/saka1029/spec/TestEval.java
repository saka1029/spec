package saka1029.spec;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static saka1029.spec.Helper.*;

public class TestEval {

    static Context context = Context.of();
    static Parser parser = new Parser();

    static Instruction eval(String s) {
        return context.eval(parser.parse(s));
    }

    @Test
    public void testArithmetic() {
        assertEquals(i(3), eval("1 2 +"));
        assertEquals(i(21), eval("1 2 + 3 4 + *"));
    }

    @Test
    public void testIf() {
        assertEquals(i(0), eval("2 even 0 1 if"));
        assertEquals(i(1), eval("3 even 0 1 if"));
        assertEquals(i(7), eval("3 4 0 even '+ '- if"));
    }
}
