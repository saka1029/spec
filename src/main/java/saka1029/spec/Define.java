package saka1029.spec;

public class Define extends Prefix {

    Define(Symbol value) {
        super(value);
    }

    public static Define of(Symbol value) {
        return new Define(value);
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    String prefix() {
        return "@";
    }

}
