package saka1029.spec;

import java.util.HashMap;
import java.util.Map;

public class SymbolGlobal extends Symbol {

    static final Map<String, SymbolGlobal> all = new HashMap<>();

    SymbolGlobal(String name) {
        super(name);
    }

    public static SymbolGlobal of(String name) {
        return all.computeIfAbsent(name, n -> new SymbolGlobal(n));
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
    }

}
