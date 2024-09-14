package saka1029.spec;

public class DefineLocal extends Prefix {

    final int offset;

    DefineLocal(Symbol value, int offset) {
        super(value);
        this.offset = offset;
    }

    public static DefineLocal of(Symbol value, int offset) {
        return new DefineLocal(value, offset);
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    String prefix() {
        return "$";
    }

}
