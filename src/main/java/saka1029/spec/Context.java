package saka1029.spec;

import java.util.ArrayList;
import java.util.List;

public class Context {

    List<Instruction> stack = new ArrayList<>();

    public void push(Instruction instruction) {
        stack.add(instruction);
    }

    public Instruction pop() {
        return stack.remove(stack.size() - 1);
    }

}
