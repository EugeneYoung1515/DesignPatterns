package second;

public class Father implements Person {
    @Override
    public void accept(PersonVisitor visitor) {
        visitor.visit(this);
    }
}
