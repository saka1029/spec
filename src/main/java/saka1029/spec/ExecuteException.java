package saka1029.spec;

public class ExecuteException extends RuntimeException {
    public ExecuteException(String format, Object... args) {
        super(format.formatted(args));
    }
}
