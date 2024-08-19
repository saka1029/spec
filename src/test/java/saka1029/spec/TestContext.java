package saka1029.spec;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Test;

import saka1029.Common;
import static saka1029.spec.Helper.*;

public class TestContext {

    static final Logger logger = Common.logger(TestContext.class);

    @Test
    public void testPushPop() {
        Context c = Context.of();
        assertEquals(0, c.stack.size());
        c.push(Int.of(2));
        assertEquals(1, c.stack.size());
        assertEquals(Int.of(2), c.pop());
        assertEquals(0, c.stack.size());
    }

    static Symbol ADD = s("+"), SUB = s("-"), IF = s("if"), EVEN = s("even");

    @Test
    public void testExecute() {
        Context c = Context.of();
        Array code = Array.of(i(1), i(2), ADD);
        assertEquals(i(3), c.eval(code));
    }

    @Test
    public void testExecuteIf() {
        Context c = Context.of();
        Array code1 = Array.of(i(2), EVEN, i(0), i(1), IF);
        assertEquals(i(0), c.eval(code1));
        Array code2 = Array.of(i(9), EVEN, i(0), i(1), IF);
        assertEquals(i(1), c.eval(code2));
    }

    @Test
    public void testExecuteIfQuote() {
        Context c = Context.of();
        Array code1 = Array.of(i(3), i(4), i(2), EVEN, q(ADD), q(SUB), IF);
        assertEquals(i(7), c.eval(code1));
        Array code2 = Array.of(i(3), i(4), i(3), EVEN, q(ADD), q(SUB), IF);
        assertEquals(i(-1), c.eval(code2));
    }
}
