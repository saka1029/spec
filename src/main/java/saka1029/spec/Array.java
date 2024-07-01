package saka1029.spec;

import java.util.Iterator;

public class Array extends List {

    final Instruction[] array;

    Array(Instruction... array) {
        this.array = array;
    }

    @Override
    public boolean isNil() {
        return array.length == 0;
    }

    @Override
    public Instruction car() {
        if (isNil())
            throw new RuntimeException("Cannot car of NIL");
        return array[0];
    }

    @Override
    public List cdr() {
        if (isNil())
            throw new RuntimeException("Cannot cdr of NIL");
        return Cons.of(1, array);
    }

    @Override
    public List cons(Instruction first) {
        return isNil() ? Cons.of(first) : Cons.of(array).cons(first);
    }

    public static List of(Instruction... array) {
        return new Array(array);
    }

    @Override
    public Iterator<Instruction> iterator() {
        return new Iterator<>() {
            int size = array.length, index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Instruction next() {
                return array[index++];
            }
        };
    }
}
