package saka1029.spec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class Proc implements Instruction {
    final Instruction body;
    final java.util.List<Symbol> inputs;
    final java.util.List<Symbol> outputs;
    final Map<Symbol, Integer> variables = new HashMap<>();
    int offset = 0;

    Proc(Instruction body, java.util.List<Symbol> inputs, java.util.List<Symbol> outputs) {
        this.body = body;
        this.inputs = new ArrayList<>(inputs);
        this.outputs = new ArrayList<>(outputs);
        int offset = -1;
        ListIterator<Symbol> it = inputs.listIterator(inputs.size());
        while (it.hasPrevious())
            variables.put(it.previous(), offset--);
    }

    public void add(Symbol name) {
        variables.put(name, offset++);
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
    }

}
