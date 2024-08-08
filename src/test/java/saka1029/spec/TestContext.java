package saka1029.spec;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestContext {

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

    @Test
    public void testExecute() {
        Instruction add = c -> c.push(i(i(c.pop()) + i(c.pop())));
        Array code = Array.of(i(1), i(2), add);
        Context c = new Context();
        assertEquals(i(3), c.eval(code));
    }
}
