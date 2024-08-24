package saka1029.spec;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import saka1029.Common;

public class Context {

    static final Logger logger = Common.logger(Context.class);

    public static Context of() {
        return new Context();
    }

    final Deque<Instruction> stack = new ArrayDeque<>();

    public void push(Instruction instruction) {
        stack.addLast(instruction);
    }

    public Instruction pop() {
        return stack.removeLast();
    }

    final Deque<Integer> fps = new ArrayDeque<>();

    final Deque<Iterator<Instruction>> instructions = new ArrayDeque<>();

    public void instruction(Iterator<Instruction> sequence) {
        instructions.addLast(sequence);
    }

    public void run() {
        L: for ( ; !instructions.isEmpty(); instructions.removeLast()) {
            int currentSize = instructions.size();
            for (Iterator<Instruction> it = instructions.getLast(); it.hasNext(); ) { 
                it.next().execute(this);
                if (instructions.size() != currentSize)
                    continue L;
            }
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

    record FrameSP(Frame frame, int sp) {}

    final Deque<FrameSP> frames = new ArrayDeque<>();

    @Override
    public String toString() {
        return stack.toString();
    }

    final Map<Symbol, Instruction> globals = new HashMap<>();

    void global(String name, Instruction inst) {
        globals.put(Symbol.of(name), inst);
    }
}
