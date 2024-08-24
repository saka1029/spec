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
        return sequence();
    }

    Instruction sequence() {
        java.util.List<Instruction> list = new ArrayList<>();
        Instruction i;
        while ((i = read()) != null)
            list.add(i);
        if (type != TokenType.END)
            throw new RuntimeException("extra token: %s".formatted(type));
        return Cons.of(list.toArray(Instruction[]::new));
    }

    Instruction list() {
        get(); // skip LP
        Instruction list = sequence();
        if (type != TokenType.RP)
            throw new RuntimeException("')' expected");
        get(); // skip RP
        return list;
    }

    Instruction advance(Instruction i) {
        get();
        return i;
    }

    Instruction symbol() {
        Symbol s = scanner.symbolValue();
        if (s == Symbol.QUOTE)
            return Quote.of(read());
        return s;
    }

    Instruction read() {
        return switch (type) {
            case END -> null;
            case INT -> advance(scanner.intValue());
            case LP -> list();
            case SYMBOL -> symbol();
            case LB -> throw new RuntimeException("unexpected '['");
            case RB -> throw new RuntimeException("unexpected ']'");
            case RP -> null;
        };
    }
}
