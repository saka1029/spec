package saka1029.spec;

public class Nop implements Instruction {

    static Nop VALUE = new Nop();

    @Override
    public void execute(Context context) {
        // do nothing
    }

}
