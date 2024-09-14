package saka1029.spec;

public class Quote extends Prefix {

    Quote(Instruction value) {
        super(value);
    }

    public static Quote of(Instruction inst) {
        return new Quote(inst);
    }

    @Override
    public void execute(Context context) {
        context.push(value);
    }

    @Override
    String prefix() {
        return "'";
    }
}
