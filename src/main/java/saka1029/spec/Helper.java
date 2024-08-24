package saka1029.spec;

public class Helper {
    private Helper() {
    }

    public static Int i(int value) {
        return Int.of(value);
    }

    public static int i(Instruction i) {
        return ((Int)i).value;
    }

    public static Bool b(boolean b) {
        return Bool.of(b);
    }

    public static boolean b(Instruction i) {
        return ((Bool)i).value;
    }

    public static Symbol s(String name) {
        return Symbol.of(name);
    }

    public static Quote q(Instruction i) {
        return Quote.of(i);
    }
}
