package saka1029.spec;

import static org.junit.Assert.assertEquals;
import static saka1029.spec.Helper.*;
import org.junit.Test;

public class TestParser {

    @Test
    public void testParse() {
        Context c = Context.of();
        Instruction inst = new Parser().parse("1 2 +");
        assertEquals(list(i(1), i(2), s("+")), inst);
        assertEquals(i(3), c.eval(inst));
    }

    @Test
    public void testList() {
        Context c = Context.of();
        Instruction inst = new Parser().parse("(1 2 +)");
        assertEquals(list(list(i(1), i(2), s("+"))), inst);
        assertEquals(i(3), c.eval(inst));
    }

    @Test
    public void testIf() {
        Parser parser = new Parser();
        assertEquals(list(list(i(1), i(2), s("+"))), parser.parse("(1 2 +)"));
    }

}
