package saka1029.spec;

import java.util.ArrayList;
import java.util.Objects;

public class Parser {

    static class ParseException extends RuntimeException {
        ParseException(String format, Object... args) {
            super(format.formatted(args));
        }
    }

    static ParseException error(String format, Object... args) {
        return new ParseException(format, args);
    }

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
        return Cons.of(list);
    }

    Instruction list() {
        get(); // skip LP
        java.util.List<Instruction> list = new ArrayList<>();
        while (type != TokenType.RP)
            list.add(readNotEnd());
        get(); // skip RP
        return Cons.of(list);
    }

    Instruction advance(Instruction i) {
        get();
        return i;
    }

    Instruction symbol() {
        Symbol s = scanner.symbolValue();
        get(); // skip SYMBOL
        if (s == Symbol.QUOTE)
            return Quote.of(readNotEnd());
        return s;
    }

    Instruction readNotEnd() {
        Instruction i = read();
        if (i == null)
            throw error("unexpected end of string");
        return i;
    }

    Instruction read() {
        return switch (type) {
            case END -> null;
            case INT -> advance(scanner.intValue());
            case SYMBOL -> symbol();
            case LP -> list();
            case LB -> throw error("unexpected '['");
            case RB -> throw error("unexpected ']'");
            case RP -> throw error("unexpected ')'");
        };
    }
}
