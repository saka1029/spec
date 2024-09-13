package saka1029.spec;

public abstract class Prefix implements Instruction {

    final Instruction value;

    Prefix(Instruction value) {
        this.value = value;
    }

    abstract String prefix();

    @Override
    public String toString() {
        return prefix() + value;
    }
}
