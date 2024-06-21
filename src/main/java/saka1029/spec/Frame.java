package saka1029.spec;

import java.util.ArrayDeque;
import java.util.Deque;

public class Frame {
    final Deque<Integer> bases = new ArrayDeque<>();
    final Proc proc;

    Frame(Proc proc) {
        this.proc = proc;
    }
}
