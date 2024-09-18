package saka1029.spec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Frame {

    final java.util.List<Instruction> instructions = new ArrayList<>();
    final java.util.List<Symbol> arguments = new ArrayList<>(), returns = new ArrayList<>();
    final Map<Symbol, Integer> locals = new LinkedHashMap<>();
    int offset;

    Frame(java.util.List<Symbol> arguments, java.util.List<Symbol> returns) {
        offset = -arguments.size();
        for (Iterator<Symbol> i = arguments.iterator(); i.hasNext(); )
            locals.put(i.next(), offset++);
    }
}
