package saka1029.spec;

public class SetLocal extends Prefix {

    final int offset;

    SetLocal(Symbol name, int offset) {
        super(name);
        this.offset = offset;
    }

    @Override
    public void execute(Context context) {
        context.setLocal(offset, context.pop());
    }

    @Override
    String prefix() {
        return "!";
    }

}
