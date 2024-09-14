package saka1029.spec;

public class Quote implements Instruction {

    final Instruction value;

    Quote(Instruction value) {
        this.value = value;
    }

    public static Quote of(Instruction inst) {
        return new Quote(inst);
    }

    @Override
    public void execute(Context context) {
        context.push(value);
    }

    @Override
    public String toString() {
        return "'" + value;
    }
}
