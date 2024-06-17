package saka1029.spec;

public class Pair extends List {
    public final Instruction first;
    public final List rest;

    Pair(Instruction first, List rest) {
        this.first = first;
        this.rest = rest;
    }
}
