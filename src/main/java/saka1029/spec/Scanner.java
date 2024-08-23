package saka1029.spec;

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

    static boolean isDigit(int ch) {
        return Character.isDigit(ch);
    }

    static boolean isSymbol(int ch) {
        return switch (ch) {
            case -1, '\'', '(', ')', '[', ']' -> false;
            default -> true;
        };
    }

    void appendGet(int ch) {
        text.appendCodePoint(ch);
        getCh();
    }

    public String text() {
        return text.toString();
    }

    int getCh() {
        return ch = index < input.length ? input[index++] : -1;
    }

    TokenType advance(TokenType t) {
        getCh();
        return t;
    }

    TokenType intOrSymbol(int prefix) {
        if (prefix != 0) {
            appendGet(prefix);
            if (!isDigit(getCh()))
                return symbol();
        }
        while (isDigit(ch))
            appendGet(ch);
        return TokenType.INT;
    }

    TokenType symbol() {
        while (isSymbol(ch))
            appendGet(ch);
        return TokenType.SYMBOL;
    }

    public TokenType get() {
        text.setLength(0);
        while (Character.isWhitespace(ch))
            getCh();
        return switch (ch) {
            case -1 -> TokenType.END;
            case '\'' -> advance(TokenType.QUOTE);
            case '(' -> advance(TokenType.LP);
            case ')' -> advance(TokenType.RP);
            case '[' -> advance(TokenType.LB);
            case ']' -> advance(TokenType.RB);
            case '+', '-' -> intOrSymbol(ch);
            default -> isDigit(ch) ? intOrSymbol(0) : symbol();
        };
    }

}
