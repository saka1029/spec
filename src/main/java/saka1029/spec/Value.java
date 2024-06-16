package saka1029.spec;

public interface Value extends Instruction {

    default void execute(Context context) {
        context.push(this);
    }

}
