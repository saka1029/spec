package saka1029.spec;

import java.util.Iterator;

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
        return of(0, instructions);
    }

    public static List of(int start, Instruction... instructions) {
        int size = instructions.length;
        List result = Array.NIL;
        for (int i = size - 1; i >= start; --i)
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

    @Override
    public Iterator<Instruction> iterator() {
        return new Iterator<>() {
            List list = Cons.this;

            @Override
            public boolean hasNext() {
                return !list.isNil();
            }

            @Override
            public Instruction next() {
                Instruction r = list.car();
                list = list.cdr();
                return r;
            }
        };
    }
}
