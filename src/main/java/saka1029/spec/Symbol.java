package saka1029.spec;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Symbol implements Instruction {

    static final Symbol QUOTE = Symbol.of("'");
    static final Map<String, Symbol> all = new HashMap<>();

    public final String name;

    Symbol(String name) {
        this.name = name;
    }

    public static Symbol of(String name) {
        return all.computeIfAbsent(name, n -> new Symbol(name));
    }

    @Override
    public void execute(Context context) {
        Instruction instruction = context.globals.get(this);
        Objects.requireNonNull(instruction, "Symbol '%s' not defined".formatted(this));
        instruction.execute(context);
    }

    @Override
    public String toString() {
        return name;
    }
}
