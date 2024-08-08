package saka1029.spec;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Context {

    public static Context of() {
        return new Context();
    }

    final Deque<Instruction> stack = new ArrayDeque<>();
    final Deque<Frame> frames = new ArrayDeque<>();

    public void push(Instruction instruction) {
        stack.addLast(instruction);
    }

    public Instruction pop() {
        return stack.removeLast();
    }

    final Deque<Iterator<Instruction>> instructions = new ArrayDeque<>();

    public void instruction(Iterator<Instruction> sequence) {
        instructions.addLast(sequence);
    }

    public void run() {
        L: while (!instructions.isEmpty()) {
            int currentSize = instructions.size();
            Iterator<Instruction> it = instructions.getLast();
            while (it.hasNext()) {
                Instruction inst = it.next();
                inst.execute(this);
                if (instructions.size() != currentSize)
                    continue L;
            }
            instructions.removeLast();
        }
    }

    public Instruction eval(Instruction inst) {
        int currentSize = stack.size();
        inst.execute(this);
        run();
        if (stack.size() != currentSize + 1)
            throw new RuntimeException("stack size %d -> %d".formatted(currentSize, stack.size()));
        return pop();
    }

    final Map<Symbol, Instruction> variables = new HashMap<>();

}
