package saka1029.spec;

public class GetLocal extends Prefix {

    final int offset; 

    GetLocal(Symbol name, int offset) {
        super(name);
        this.offset = offset;
    }

    public static GetLocal of(Symbol name, int offset) {
        return new GetLocal(name, offset);
    }

    @Override
    public void execute(Context context) {
        context.getLocal(offset);
    }

    @Override
    String prefix() {
        return "";
    }

}
