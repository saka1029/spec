package saka1029.spec;

import java.util.HashMap;
import java.util.Map;

public class Symbol implements Instruction {

    static final Map<String, Symbol> symbols = new HashMap<>();
    public final String name;

    Symbol(String name) {
        this.name = name;
    }

    public Symbol of(String name) {
        return symbols.computeIfAbsent(name, n -> new Symbol(n));
    }

    @Override
    public void execute(Context context) {
        Instruction inst = context.variables.get(this);
        if (inst == null)
            throw new RuntimeException("Symbol '%s' not found".formatted(this));
        inst.execute(context);
    }

    @Override
    public String toString() {
        return name;
    }

}
