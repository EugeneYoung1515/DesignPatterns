package first;

public class FatherPrint implements Visitor<Father,Void> {
    @Override
    public Void visit(Father father) {
        System.out.println("father:"+father);
        return null;
    }
}
