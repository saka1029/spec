package saka1029.spec;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Context {

    final Deque<Instruction> stack = new ArrayDeque<>();
    final Deque<Frame> frames = new ArrayDeque<>();

    public void push(Instruction instruction) {
        stack.add(instruction);
    }

    public Instruction pop() {
        return stack.removeLast();
    }

    final Map<Symbol, Instruction> variables = new HashMap<>();

    final Deque<Sequence> instructions = new ArrayDeque<>();

    public void instruction(Sequence sequence) {
        instructions.add(sequence);
    }

}
