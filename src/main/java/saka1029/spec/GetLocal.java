package saka1029.spec;

public class GetLocal extends Prefix {

    final int offset, nest; 

    GetLocal(Symbol name, int offset, int nest) {
        super(name);
        this.offset = offset;
        this.nest = nest;
    }

    public static GetLocal of(Symbol name, int offset, int nest) {
        return new GetLocal(name, offset, nest);
    }

    @Override
    public void execute(Context context) {
        context.getLocal(offset, nest);
    }

    @Override
    String prefix() {
        return "";
    }

}
