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
    }
}
