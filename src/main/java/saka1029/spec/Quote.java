package saka1029.spec;

import java.util.Objects;

public class Quote implements Instruction {

    final Instruction inst;

    Quote(Instruction inst) {
        Objects.requireNonNull(inst);
        this.inst = inst;
    }

    public static Quote of(Instruction inst) {
        return new Quote(inst);
    }

    @Override
    public void execute(Context context) {
        context.push(inst);
    }

    @Override
    public String toString() {
        return "'" + inst;
    }
}
