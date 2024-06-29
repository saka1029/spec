package saka1029.spec;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Context {

    final Deque<Instruction> stack = new ArrayDeque<>();
    final Deque<Frame> frames = new ArrayDeque<>();

    public void push(Instruction instruction) {
        stack.addLast(instruction);
    }

    public Instruction pop() {
        return stack.removeLast();
    }

    final Map<Symbol, Instruction> variables = new HashMap<>();

    final Deque<Iterator<Instruction>> instructions = new ArrayDeque<>();

    public void instruction(Iterator<Instruction> sequence) {
        instructions.addLast(sequence);
    }

}
