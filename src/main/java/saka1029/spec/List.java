package saka1029.spec;

import java.util.Iterator;

public abstract class List implements Instruction, Iterable<Instruction> {

    public static final List NIL = Array.of();

    public abstract boolean isNil();
    public abstract Instruction car();
    public abstract List cdr();
    public abstract List cons(Instruction first);

    @Override
    public void execute(Context context) {
        context.instruction(iterator());
    }

    @Override
    public int hashCode() {
        int hash = 17;
        Iterator<Instruction> it = iterator();
        while (it.hasNext())
            hash = hash * 31 + it.next().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof List list))
            return false;
        Iterator<Instruction> left = iterator(), right = list.iterator();
        while (left.hasNext() && right.hasNext())
            if (!left.next().equals(right.next()))
                return false;
        if (left.hasNext() || right.hasNext())
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Iterator<Instruction> it = iterator();
        if (it.hasNext()) {
            sb.append(it.next());
            while (it.hasNext())
                sb.append(" ").append(it.next());
        }
        return sb.append(")").toString();
    }
}
