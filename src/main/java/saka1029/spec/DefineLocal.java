package saka1029.spec;

public class DefineLocal extends Prefix {

    final int offset;

    DefineLocal(Symbol name, int offset) {
        super(name);
        this.offset = offset;
    }

    public static DefineLocal of(Symbol name, int offset) {
        return new DefineLocal(name, offset);
    }

    @Override
    public void execute(Context context) {
        context.setLocal(offset, context.pop());
    }

    @Override
    String prefix() {
        return "$";
    }

}
