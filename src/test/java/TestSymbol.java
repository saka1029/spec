import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import saka1029.spec.SymbolGlobal;
import saka1029.spec.SymbolLocal;

public class TestSymbol {

    @Test
    public void testEquals() {
        assertEquals(SymbolGlobal.of("abc"), SymbolGlobal.of("abc"));
        assertNotEquals(SymbolLocal.of("abc"), SymbolLocal.of("abc"));
    }
}
