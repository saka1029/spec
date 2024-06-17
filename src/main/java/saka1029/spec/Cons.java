package saka1029.spec;

public class Cons extends List {
    public final Instruction car;
    public final List cdr;

    Cons(Instruction first, List rest) {
        this.car = first;
        this.cdr = rest;
    }

    public static List list(Instruction... instructions) {
        int size = instructions.length;
        List result = List.NIL;
        for (int i = size - 1; i >= 0; --i)
            result = new Cons(instructions[i], result);
        return result;
    }

    @Override
    public Sequence sequence() {
        return new Sequence() {
            List list = Cons.this;

            @Override
            public Instruction next() {
                if (list instanceof Cons cons) {
                    list = cons.cdr;
                    return cons.car;
                }
                return null;
            }
        };
    }
}
