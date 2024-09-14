package saka1029.spec;

public class DefineLocal extends Prefix {

    DefineLocal(Symbol value) {
        super(value);
    }

    public static DefineLocal of(Symbol value) {
        return new DefineLocal(value);
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
