package saka1029.spec;

public class DefineGlobal extends Prefix {

    DefineGlobal(Symbol name) {
        super(name);
    }

    public static DefineGlobal of(Symbol name) {
        return new DefineGlobal(name);
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
