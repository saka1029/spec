package saka1029.spec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import saka1029.Common;
import static saka1029.spec.Helper.*;

public class Context {

    static final Logger logger = Common.logger(Context.class);

    private Context() {
    }

    public static Context of() {
        Context context = new Context();
        context.initialize();
        return context;
    }

    final ArrayList<Instruction> stack = new ArrayList<>();

    public void push(Instruction instruction) {
        stack.add(instruction);
    }

    public Instruction pop() {
        return stack.remove(stack.size() - 1);
    }

    public Instruction getLocal(int offset, int nest) {
        return stack.get(fstack.get(nest) + offset);
    }

    public void setLocal(int offset, int nest, Instruction instruction) {
        stack.set(fstack.get(nest) + offset, instruction);
    }

    final java.util.List<Integer> fstack = new ArrayList<>();

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

    @Override
    public String toString() {
        return stack.toString();
    }

    final Map<Symbol, Instruction> globals = new HashMap<>();

    void define(String name, Instruction inst) {
        globals.put(Symbol.of(name), inst);
    }

    void setGlobal(Symbol name, Instruction inst) {
        if (!globals.containsKey(name))
            throw new RuntimeException("'%s' undefined".formatted(name));
        globals.put(name, inst);
    }

    void initialize() {
        define("+", c -> c.push(i(i(c.pop()) + i(c.pop()))));
        define("-", c -> { int r = i(c.pop()), l = i(c.pop()); c.push(i(l - r)); });
        define("even", c -> c.push(b(i(c.pop()) % 2 == 0)));
        define("if", c -> {
            Instruction otherwise = c.pop(), then = c.pop();
            if (b(c.pop()))
                then.execute(c);
            else
                otherwise.execute(c);
        });
    }
}
