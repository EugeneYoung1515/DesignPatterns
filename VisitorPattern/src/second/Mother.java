package second;

public class Mother implements Person {
    @Override
    public void accept(PersonVisitor visitor) {
        visitor.visit(this);
    }
}
