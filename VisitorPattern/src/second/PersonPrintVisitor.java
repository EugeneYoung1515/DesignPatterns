package second;

public class PersonPrintVisitor implements PersonVisitor {
    @Override
    public void visit(Father father) {
        System.out.println("father:"+father);
    }

    @Override
    public void visit(Mother mother) {
        System.out.println("mother:"+mother);
    }
}
