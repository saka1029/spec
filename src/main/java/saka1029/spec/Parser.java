package saka1029.spec;

import java.util.ArrayList;

public class Parser {

    static final Symbol DEFINE = Symbol.of("define");
    static final Symbol LOCAL = Symbol.of("local");
    static final Symbol SET = Symbol.of("set");

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
        LocalVars f = LocalVars.of();
        java.util.List<Instruction> list = new ArrayList<>();
        while (type != TokenType.END)
            list.add(read2(f));
        return Cons.of(list);
    }

    Instruction list(LocalVars f) {
        get(); // skip LP
        java.util.List<Instruction> list = new ArrayList<>();
        while (type != TokenType.RP)
            list.add(read2(f));
        get(); // skip RP
        return Cons.of(list);
    }

    Instruction advance(Instruction i) {
        get();
        return i;
    }

    Symbol symbol() {
        if (get() != TokenType.SYMBOL)
            throw error("symbol expected");
        return scanner.symbolValue();
    }

    Instruction symbol(LocalVars f) {
        Symbol s = scanner.symbolValue();
        get(); // skip SYMBOL
        if (s == DEFINE)
            return DefineGlobal.of(symbol());
        else if (s == LOCAL)
            return f.defineLocal(symbol());
        else if (s == SET)
            return f.set(symbol());
        else
            return s;
    }

    Instruction read2(LocalVars f) {
        Instruction i = read(f);
        if (i instanceof Symbol sym)
            i = f.get(sym);
        return i;
    }

    Quote quote(LocalVars f) {
        get(); // skip QUOTE
        return Quote.of(read2(f));
    }

    Instruction read(LocalVars f) {
        return switch (type) {
            case END -> throw error("unexpected end");
            case INT -> advance(scanner.intValue());
            case SYMBOL -> symbol(f);
            case QUOTE -> quote(f);
            case LP -> list(f);
            case LB -> throw error("unexpected '['");
            case RB -> throw error("unexpected ']'");
            case RP -> throw error("unexpected ')'");
        };
    }
}
