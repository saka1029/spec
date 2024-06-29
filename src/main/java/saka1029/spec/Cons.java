package saka1029.spec;

public class Cons extends List {
    public final Instruction car;
    public final List cdr;

    Cons(Instruction first, List rest) {
        this.car = first;
        this.cdr = rest;
    }

    public static List of(Instruction first, List rest) {
        return new Cons(first, rest);
    }

    public static List of(Instruction... instructions) {
        int size = instructions.length;
        List result = Array.NIL;
        for (int i = size - 1; i >= 0; --i)
            result = new Cons(instructions[i], result);
        return result;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Instruction car() {
        return car;
    }

    @Override
    public List cdr() {
        return cdr;
    }

    @Override
    public List cons(Instruction first) {
        return of(first, this);
    }
}
