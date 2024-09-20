package saka1029.spec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Frame implements Instruction {

    final java.util.List<Instruction> instructions = new ArrayList<>();
    final java.util.List<Symbol> arguments = new ArrayList<>(), returns = new ArrayList<>();
    final Map<Symbol, Integer> argLocal = new LinkedHashMap<>();
    int offset;

    Frame(java.util.List<Symbol> arguments, java.util.List<Symbol> returns) {
        offset = -arguments.size();
        for (Iterator<Symbol> i = arguments.iterator(); i.hasNext(); )
            argLocal.put(i.next(), offset++);
    }

    @Override
    public void execute(Context context) {
        // prolog
        context.fstack.add(context.stack.size());
        // ローカル変数領域の確保
        int localSize = argLocal.size() - arguments.size();
        for (int i = 0; i < localSize; ++i)
            context.push(Nop.VALUE);
        // execute
        context.instruction(instructions.iterator());
        // epilog
    }
}
