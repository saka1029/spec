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
}
