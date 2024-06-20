package saka1029.spec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Context {

    final Deque<Instruction> stack = new ArrayDeque<>();

    public void push(Instruction instruction) {
        stack.add(instruction);
    }

    public Instruction pop() {
        return stack.removeLast();
    }

    final Map<Symbol, Instruction> variables = new HashMap<>();

    final java.util.List<Sequence> instructions = new ArrayList<>();

    public void instruction(Sequence sequence) {
        instructions.add(sequence);
    }

}
