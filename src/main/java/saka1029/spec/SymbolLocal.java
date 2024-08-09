package saka1029.spec;

public class SymbolLocal extends Symbol {

    SymbolLocal(String name) {
        super(name);
    }

    public static SymbolLocal of(String name) {
        return new SymbolLocal(name);
    }

    @Override
    public void execute(Context context) {
        // TODO Auto-generated method stub
    }

}
