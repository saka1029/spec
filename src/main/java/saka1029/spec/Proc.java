package saka1029.spec;

import java.util.HashMap;
import java.util.Map;

public class Proc {
    public final Instruction expression;
    final Map<Symbol, Integer> offsets = new HashMap<>();

    Proc(Instruction expression) {
        this.expression = expression;
    }

}
