package saka1029.spec;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.Test;

import saka1029.Common;

public class TestContext {

    static final Logger logger = Common.logger(TestContext.class);

    @Test
    public void testPushPop() {
        Context c = new Context();
        assertEquals(0, c.stack.size());
        c.push(Int.of(2));
        assertEquals(1, c.stack.size());
        assertEquals(Int.of(2), c.pop());
        assertEquals(0, c.stack.size());
    }

    static Int i(int i) {
        return Int.of(i);
    }

    static int i(Instruction i) {
        return ((Int)i).value;
    }

    static Bool b(boolean b) {
        return Bool.of(b);
    }

    static boolean b(Instruction b) {
        return ((Bool)b).value;
    }

    static Quote q(Instruction inst) {
        return Quote.of(inst);
    }

    static Instruction add = c -> c.push(i(i(c.pop()) + i(c.pop())));
    static Instruction sub = c -> { int r = i(c.pop()), l = i(c.pop()); c.push(i(l - r)); };
    static Instruction even = c -> c.push(b(i(c.pop()) % 2 == 0));
    static Instruction IF = c -> {
        Instruction otherwise = c.pop(), then = c.pop();
        if (b(c.pop()))
            then.execute(c);
        else
            otherwise.execute(c);
    };

    @Test
    public void testExecute() {
        Context c = new Context();
        Array code = Array.of(i(1), i(2), add);
        assertEquals(i(3), c.eval(code));
    }

    @Test
    public void testExecuteIf() {
        Context c = new Context();
        Array code1 = Array.of(i(2), even, i(0), i(1), IF);
        assertEquals(i(0), c.eval(code1));
        Array code2 = Array.of(i(9), even, i(0), i(1), IF);
        assertEquals(i(1), c.eval(code2));
    }

    @Test
    public void testExecuteIfQuote() {
        Context c = new Context();
        Array code1 = Array.of(i(3), i(4), i(2), even, q(add), q(sub), IF);
        assertEquals(i(7), c.eval(code1));
        Array code2 = Array.of(i(3), i(4), i(3), even, q(add), q(sub), IF);
        assertEquals(i(-1), c.eval(code2));
    }
}
