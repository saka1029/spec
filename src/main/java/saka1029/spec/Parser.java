package saka1029.spec;

import java.util.ArrayList;

public class Parser {

    static final Symbol DEFINE = Symbol.of("define");
    static final Symbol LOCAL = Symbol.of("local");
    static final Symbol SET = Symbol.of("set");
    static final Symbol DASH = Symbol.of("-");
    static final Symbol COLON = Symbol.of(":");

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
            list.add(read(f));
        return Cons.of(list);
    }

    Instruction list(LocalVars f) {
        get(); // skip LP
        java.util.List<Instruction> list = new ArrayList<>();
        while (type != TokenType.RP)
            list.add(read(f));
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

    Quote quote(LocalVars f) {
        get(); // skip QUOTE
        return Quote.of(read(f));
    }

    java.util.List<Symbol> symbols(LocalVars f) {
        java.util.List<Symbol> list = new ArrayList<>();
        while (type == TokenType.SYMBOL) {
            Symbol symbol = scanner.symbolValue();
            if (symbol == DASH || symbol == COLON)
                break;
            list.add(symbol);
            get(); // skip SYMBOL
        }
        return list;
    }

    Frame frame(LocalVars f) {
        get(); // skip '['
        java.util.List<Symbol> arguments = symbols(f);
        if (type != TokenType.SYMBOL || scanner.symbolValue() != DASH)
            error("'-' expected");
        get(); // skip '-'
        java.util.List<Symbol> returns = symbols(f);
        if (type != TokenType.SYMBOL || scanner.symbolValue() != COLON)
            error("':' expected");
        Frame frame = f.beginFrame(arguments, returns);
        while (type != TokenType.RB)
            frame.instructions.add(read(f));
        get(); // skip ']'
        return f.endFrame();
    }

    Instruction read(LocalVars f) {
        return switch (type) {
            case END -> throw error("unexpected end");
            case QUOTE -> quote(f);
            case INT -> advance(scanner.intValue());
            case SYMBOL -> symbol(f);
            case LP -> list(f);
            case LB -> throw error("unexpected '['");
            case RB -> frame(f);
            case RP -> throw error("unexpected ')'");
        };
    }
}
