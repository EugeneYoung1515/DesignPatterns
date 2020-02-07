package first;

public class Father implements Ele<Father> {
    @Override
    public <R> R accept(Visitor<Father, R> visitor) {
        return visitor.visit(this);
    }
}
