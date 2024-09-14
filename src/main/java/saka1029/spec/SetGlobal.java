package saka1029.spec;

public class SetGlobal extends Prefix {

    SetGlobal(Symbol value) {
        super(value);
    }

    public static SetGlobal of(Symbol value) {
        return new SetGlobal(value);
    }

    @Override
    public void execute(Context context) {
        context.setGlobal(name, context.pop());
    }

    @Override
    String prefix() {
        return "!";
    }

}
