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

    public static List list(Instruction... instructions) {
        int size = instructions.length;
        List result = List.NIL;
        for (int i = size - 1; i >= 0; --i)
            result = new Cons(instructions[i], result);
        return result;
    }

    @Override
    public Iterator<Instruction> iterator() {
        return new Iterator<>() {
            Iterator<Instruction> rest = null;

            @Override
            public boolean hasNext() {
                return rest == null || rest.hasNext();
            }

            @Override
            public Instruction next() {
                if (rest == null) {
                    rest = cdr.iterator();
                    return car;
                }
                return rest.next();
            }
        };
    }
}
