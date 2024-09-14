package saka1029.spec;

public abstract class Prefix implements Instruction {

    final Instruction value;

    Prefix(Instruction value) {
        if (value == null)
            throw new IllegalArgumentException("value is null");
        this.value = value;
    }

    abstract String prefix();

    @Override
    public String toString() {
        return prefix() + value;
    }
}
