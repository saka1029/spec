package saka1029.spec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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
        Deque<Frame> f = new ArrayDeque<>();
        java.util.List<Instruction> list = new ArrayList<>();
        Instruction i;
        while ((i = read(f)) != null)
            list.add(i);
        return Cons.of(list);
    }

    Instruction list(Deque<Frame> f) {
        get(); // skip LP
        java.util.List<Instruction> list = new ArrayList<>();
        while (type != TokenType.RP)
            list.add(readNotEnd(f));
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
        return s;
    }

    Instruction readNotEnd(Deque<Frame> f) {
        Instruction i = read(f);
        if (i == null)
            throw error("unexpected end of string");
        return i;
    }

    Quote quote(Deque<Frame> f) {
        get(); // skip QUOTE
        return Quote.of(read(f));
    }

    DefineGlobal defineGlobal(Deque<Frame> f) {
        get(); // skip DEFINE_GLOBAL;
        Instruction inst = read(f);
        if (inst instanceof Symbol s)
            return DefineGlobal.of(s);
        else
            throw error("symbol expected");
    }

    DefineLocal defineLocal(Deque<Frame> f) {
        get(); // skip DEFINE_LOCAL;
        return null;
    }

    Instruction store(Deque<Frame> f) {
        return null;
    }

    Instruction read(Deque<Frame> f) {
        return switch (type) {
            case END -> null;
            case INT -> advance(scanner.intValue());
            case SYMBOL -> symbol();
            case QUOTE -> quote(f);
            case DEFINE_GLOBAL -> defineGlobal(f);
            case DEFINE_LOCAL -> defineLocal(f);
            case STORE -> store(f);
            case LP -> list(f);
            case LB -> throw error("unexpected '['");
            case RB -> throw error("unexpected ']'");
            case RP -> throw error("unexpected ')'");
        };
    }
}
