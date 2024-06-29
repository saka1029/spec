package saka1029.spec;

import java.util.Iterator;

public class Array extends List {

    final Instruction[] array;

    Array(Instruction... array) {
        this.array = array;
    }

    @Override
    public Iterator<Instruction> iterator() {
        return new Iterator<>() {
            int size = array.length, i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Instruction next() {
                return array[i++];
            }
        };
    }

}
