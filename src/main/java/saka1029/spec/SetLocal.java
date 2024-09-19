package saka1029.spec;

public class SetLocal extends Prefix {

    final int offset, nest;

    SetLocal(Symbol name, int offset, int nest) {
        super(name);
        this.offset = offset;
        this.nest = nest;
    }

    public static SetLocal of(Symbol name, int offset, int nest) {
        return new SetLocal(name, offset, nest);
    }

    @Override
    public void execute(Context context) {
        context.setLocal(offset, nest, context.pop());
    }

    @Override
    String prefix() {
        return "!";
    }

}
