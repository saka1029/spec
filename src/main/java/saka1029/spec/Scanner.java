package saka1029.spec;

import java.util.regex.Pattern;

public class Scanner {

    final int[] input;
    int index;
    int ch;
    final StringBuilder text = new StringBuilder();

    Scanner(String input) {
        this.input = input.codePoints().toArray();
        this.index = 0;
        getCh();
    }

    public static Scanner of(String text) {
        return new Scanner(text);
    }

    static boolean isSpace(int ch) {
        return Character.isWhitespace(ch);
    }

    static boolean isDigit(int ch) {
        return Character.isDigit(ch);
    }

    static boolean isWord(int ch) {
        if (isSpace(ch))
            return false;
        return switch (ch) {
            case -1, '\'', '(', ')', '[', ']' -> false;
            default -> true;
        };
    }

    public Symbol symbolValue() {
        return Symbol.of(text.toString());
    }

    public Int intValue() {
        return Int.of(Integer.parseInt(text.toString()));
    }

    int getCh() {
        return ch = index < input.length ? input[index++] : -1;
    }

    TokenType advance(TokenType t) {
        getCh();
        return t;
    }

    TokenType quote() {
        text.appendCodePoint('\'');
        getCh();
        return TokenType.QUOTE;
    }

    static final Pattern INTPAT = Pattern.compile("[-+]?\\d+");

    TokenType intOrSymbol() {
        while (isWord(ch)) {
            text.appendCodePoint(ch);
            getCh();
        }
        return INTPAT.matcher(text).matches() ? TokenType.INT : TokenType.SYMBOL;
    }

    public TokenType get() {
        text.setLength(0);
        while (isSpace(ch))
            getCh();
        return switch (ch) {
            case -1 -> TokenType.END;
            case '\'' -> quote();
            case '(' -> advance(TokenType.LP);
            case ')' -> advance(TokenType.RP);
            case '[' -> advance(TokenType.LB);
            case ']' -> advance(TokenType.RB);
            default -> intOrSymbol();
        };
    }
}
