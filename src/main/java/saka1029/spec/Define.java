package saka1029.spec;

public class Define extends Prefix {

    Define(Symbol name) {
        super(name);
    }

    public static Define of(Symbol name) {
        return new Define(name);
    }

    @Override
    public void execute(Context context) {
        Instruction body = context.pop();
        context.globals.put(name, body);
    }

    @Override
    String prefix() {
        return "@";
    }

}
