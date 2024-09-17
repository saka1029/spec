package saka1029.spec;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ListIterator;

public class Frame {

    final java.util.List<Instruction> instructions = new ArrayList<>();
    final java.util.List<Symbol> inputs = new ArrayList<>(), outputs = new ArrayList<>();
    final LinkedHashMap<Symbol, Integer> locals = new LinkedHashMap<>();
    int localOffset = 0;

    Frame(java.util.List<Symbol> arguments) {
        int pos = -1;
        for (ListIterator<Symbol> i = arguments.listIterator(arguments.size()); i.hasPrevious(); )
            locals.put(i.next(), pos--);
    }

    void defineLocal(Symbol name) {
        locals.put(name, localOffset);
        add(DefineLocal.of(name, localOffset++));
    }

    boolean setLocal(Symbol name) {
        Integer offset = locals.get(name);
        if (offset == null)
            return false;
        add(SetLocal.of(name, offset));
        return true;
    }

    void add(Instruction inst) {
        instructions.add(inst);
    }
}
