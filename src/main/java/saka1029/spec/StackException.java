package saka1029.spec;

public class StackException extends RuntimeException {
    public StackException(String format, Object... args) {
        super(format.formatted(args));
    }
}
