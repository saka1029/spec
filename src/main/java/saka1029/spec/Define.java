package saka1029.spec;

public class Define extends Prefix {

    Define(Symbol value) {
        super(value);
    }

    public static Define of(Symbol value) {
        return new Define(value);
    }

    @Override
    public void execute(Context context) {
        Instruction body = context.pop();
        context.globals.put((Symbol)value, body);
    }

    @Override
    String prefix() {
        return "@";
    }

}
