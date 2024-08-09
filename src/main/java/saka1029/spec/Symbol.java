package saka1029.spec;

public abstract class Symbol implements Instruction {

    public final String name;

    Symbol(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
