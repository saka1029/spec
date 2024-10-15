package saka1029.spec;

import static org.junit.Assert.assertEquals;
import static saka1029.spec.Helper.*;
import org.junit.Test;

public class TestParser {

    static Context context = Context.of();
    static Parser parser = new Parser();

    @Test
    public void testParse() {
        Instruction inst = parser.parse("1 2 +");
        assertEquals(list(i(1), i(2), s("+")), inst);
        assertEquals(i(3), context.eval(inst));
    }

    @Test
    public void testIf() {
        Instruction inst = parser.parse("2 even 0 1 if");
        assertEquals(i(0), context.eval(inst));
    }

}
