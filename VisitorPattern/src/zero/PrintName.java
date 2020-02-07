package zero;

public class PrintName implements Visitor<Void> {

    private String s;

    public PrintName(String s) {
        this.s = s;
    }

    @Override
    public Void visit( Child child) {
        System.out.println("name: "+child.name);

        Integer ss = new PrintAndReturnAge(s).visit(child);//这个new放到实例变量那里也可以
        System.out.println("return age: "+ss);

        return null;
    }
}
