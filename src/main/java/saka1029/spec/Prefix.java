package saka1029.spec;

public abstract class Prefix implements Instruction {

    final Symbol name;

    Prefix(Symbol name) {
        if (name == null)
            throw new IllegalArgumentException("value is null");
        this.name = name;
    }

    abstract String prefix();

    @Override
    public String toString() {
        return prefix() + name;
    }
}
