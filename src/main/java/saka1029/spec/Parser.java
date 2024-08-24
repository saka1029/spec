package saka1029.spec;

import java.util.ArrayList;

public class Parser {

    Scanner scanner;
    TokenType type;

    TokenType get() {
        return type = scanner.get();
    }

    Instruction parse(String input) {
        scanner = Scanner.of(input);
        get();
        java.util.List<Instruction> list = new ArrayList<>();
        Instruction i;
        while ((i = read()) != null)
            list.add(i);
        return Cons.of(list.toArray(Instruction[]::new));
    }

    List list() {
        get(); // skip LP
        java.util.List<Instruction> list = new ArrayList<>();
        return Cons.of(list.toArray(Instruction[]::new));
    }

    Instruction read() {
        return switch (type) {
            case END -> null;
            case SYMBOL -> scanner.symbolValue();
            case INT -> scanner.intValue();
            case LP -> list();
            default -> null;
        };
    }
}
