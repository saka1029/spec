package saka1029.spec;

import java.util.HashMap;
import java.util.Map;

public class Proc implements Instruction {
    final Instruction body;
    final Frame frame;

    Proc(Instruction body, int returns, Symbol... arguments) {
        this.body = body;
        Map<Symbol, Integer> locals = new HashMap<>();
        int offset = -1;
        for (int i = arguments.length - 1; i >= 0; --i, --offset)
            locals.put(arguments[i], offset);
        this.frame = new Frame(this, locals);
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
    }

}
