package second;

public interface PersonVisitor {
    void visit(Father father);
    void visit(Mother mother);
}
