package saka1029.spec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {

    final List<Instruction> stack = new ArrayList<>();

    public void push(Instruction instruction) {
        stack.add(instruction);
    }

    public Instruction pop() {
        return stack.remove(stack.size() - 1);
    }

    final Map<Symbol, Instruction> variables = new HashMap<>();

    final java.util.List<Sequence> instructions = new ArrayList<>();

    public void instruction(Sequence sequence) {
        instructions.add(sequence);
    }

}
