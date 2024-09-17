package saka1029.spec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class Frame {

    final java.util.List<Symbol> inputs = new ArrayList<>(), outputs = new ArrayList<>();
    final Map<Symbol, Integer> locals = new HashMap<>();
    int offset = 0;

    Frame(java.util.List<Symbol> arguments) {
        int pos = -1;
        for (ListIterator<Symbol> i = arguments.listIterator(arguments.size()); i.hasPrevious(); )
            locals.put(i.next(), pos--);
    }

}
