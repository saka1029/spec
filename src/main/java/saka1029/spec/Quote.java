package saka1029.spec;

public class Quote implements Instruction {

    final Instruction inst;

    Quote(Instruction inst) {
        this.inst = inst;
    }

    public Quote of(Instruction inst) {
        return new Quote(inst);
    }

    @Override
    public void execute(Context context) {
        inst.execute(context);
    }

    @Override
    public String toString() {
        return "'" + inst;
    }
}
