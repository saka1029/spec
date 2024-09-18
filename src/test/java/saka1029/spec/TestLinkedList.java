package saka1029.spec;

import java.util.LinkedHashMap;
import java.util.Map;
import static saka1029.spec.Helper.*;

import org.junit.Test;

public class TestLinkedList {

    @Test
    public void testPut() {
        Map<Symbol, Integer> map = new LinkedHashMap<>();
        map.put(s("a"), 1);
        map.put(s("b"), 2);
        map.put(s("c"), 3);
        map.put(s("a"), 100);
        System.out.println(map);
    }

}
