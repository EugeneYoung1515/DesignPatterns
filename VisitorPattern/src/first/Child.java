package first;

public class Child implements Ele<Child> {
    public int age;
    public String name;

    public Child(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public <R> R accept(Visitor<Child, R> visitor) {
        return visitor.visit(this);
    }
}
