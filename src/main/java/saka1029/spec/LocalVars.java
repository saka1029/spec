package saka1029.spec;

import java.util.ArrayList;

public class LocalVars {
    final java.util.List<Frame> frames = new ArrayList<>();

    void addFrame(java.util.List<Symbol> arguments, java.util.List<Symbol> returns) {
        frames.add(new Frame(arguments, returns));
    }

    DefineLocal defineLocal(Symbol name) {
        if (frames.isEmpty())
            throw new ParseException("define local not in a frame");
        Frame f = frames.get(frames.size() - 1);
        if (f.locals.containsKey(name))
            throw new ParseException("Symbol '%s' is already defined as local", name);
        return DefineLocal.of(name, f.offset++);
    }

    /**
     * Returns Symbol (get global) or GetLocal
     */
    Instruction get(Symbol name) {
        for (int i = frames.size() - 1; i >= 0; --i) {
            Integer offset = frames.get(i).locals.get(name);
            if (offset != null)
                return GetLocal.of(name, offset, i);
        }
        return name;  // get global 
    }
}
