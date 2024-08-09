package saka1029.spec;

import java.util.Map;

public class Frame {
    final Map<Symbol, Integer> locals;
    final Proc self;

    Frame(Proc self, Map<Symbol, Integer> locals) {
        this.locals = locals;
        this.self = self;
    }
}
