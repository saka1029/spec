package saka1029.spec;

import java.util.HashMap;
import java.util.Map;

public class Proc implements Instruction {
    final Instruction body;
    final Map<Symbol, Integer> variables = new HashMap<>();
    int offset = 0;

    Proc(Instruction body, int returns, Symbol... arguments) {
        this.body = body;
        int offset = -1;
        for (int i = arguments.length - 1; i >= 0; --i)
            variables.put(arguments[i], offset--);
    }

    public void add(Symbol name) {
        variables.put(name, offset++);
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
    }

}
