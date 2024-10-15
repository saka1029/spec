package saka1029.spec;

import static org.junit.Assert.assertEquals;
import static saka1029.spec.Helper.*;
import org.junit.Test;

public class TestParser {

    @Test
    public void testParse() {
        Parser parser = new Parser();
        assertEquals(list(i(1), i(2), s("+")), parser.parse("1 2 +"));
    }

    @Test
    public void testList() {
        Parser parser = new Parser();
        assertEquals(list(list(i(1), i(2), s("+"))), parser.parse("(1 2 +)"));
    }

}
