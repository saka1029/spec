package saka1029.spec;

public class SetLocal extends Prefix {

    final int offset;

    SetLocal(Symbol name, int offset) {
        super(name);
        this.offset = offset;
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
