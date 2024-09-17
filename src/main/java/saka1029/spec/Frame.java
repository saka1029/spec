package saka1029.spec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class Frame implements Instruction {

    final java.util.List<Symbol> inputs = new ArrayList<>(), outputs = new ArrayList<>();
    final Map<Symbol, Integer> locals = new HashMap<>();
    int localOffset = 0;

    Frame(java.util.List<Symbol> arguments) {
        int pos = -1;
        for (ListIterator<Symbol> i = arguments.listIterator(arguments.size()); i.hasPrevious(); )
            locals.put(i.next(), pos--);
    }

    int addLocal(Symbol name) {
        locals.put(name, localOffset);
        return localOffset++;
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
