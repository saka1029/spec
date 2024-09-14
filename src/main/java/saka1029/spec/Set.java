package saka1029.spec;

public class Set extends Prefix {

    Set(Symbol value) {
        super(value);
    }

    public static Set of(Symbol value) {
        return new Set(value);
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    String prefix() {
        return "!";
    }

}
