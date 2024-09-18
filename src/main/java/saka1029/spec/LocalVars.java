package saka1029.spec;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LocalVars {
    final java.util.List<Frame> frames = new ArrayList<>();

    void addFrame(java.util.List<Symbol> arguments, java.util.List<Symbol> returns) {
        frames.add(new Frame(arguments, returns));
    }

    DefineLocal defineLocal(Symbol name) {
        if (locals.containsKey(name))
            throw new StackException("symbol '%s' is already defined as local", name);
        return DefineLocal.of(name, offset++);
    }

    /**
     * Returns Symbol (get global) or GetLocal
     */
    Instruction get(Symbol name) {
        Integer offset = locals.get(name);
        return offset == null ?  name : GetLocal.of(name, offset);
    }
}
