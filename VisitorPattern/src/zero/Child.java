package zero;

public class Child{
    public int age;
    public String name;

    public Child(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public <T> T accept(Visitor<T> visitor){
        return visitor.visit(this);
    }

}
