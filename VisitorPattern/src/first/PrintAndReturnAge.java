package first;

public class PrintAndReturnAge implements Visitor<Child,Integer> {
    private String s;

    public PrintAndReturnAge(String s) {
        this.s = s;
    }

    public Integer visit(Child child) {
        System.out.println("age: "+child.age);
        System.out.println("param: "+s);
        return child.age;
    }
}
