package third.first.second;

public interface ExpVisitor<T> {

    T visit(Literal e);

    T visit(Add e);

    T visit(Subtract e);

    T visit(Multiply e);

}

interface Exp {
     <T> T accept(ExpVisitor<T> visitor);
}

class Literal implements Exp {
    public final int val;

    public Literal(int val) {
        this.val = val;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Add implements Exp {
    public final int a;
    public final int b;

    public Add(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Subtract implements Exp {
    public final int a;
    public final int b;

    public Subtract(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Multiply implements Exp {
    public final int a;
    public final int b;

    public Multiply(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class ExpEvalVisitor implements ExpVisitor<Integer> {
    @Override
    public Integer visit(Literal e) {
        return e.val;
    }

    @Override
    public Integer visit(Add e) {
        return e.a+e.b;
    }

    @Override
    public Integer visit(Subtract e) {
        return e.a-e.b;
    }

    @Override
    public Integer visit(Multiply e) {
        return e.a*e.b;
    }
}

//新增
class ExpShowVisitor implements ExpVisitor<String> {
    @Override
    public String visit(Literal e) {
        return e.val+"";
    }

    @Override
    public String visit(Add e) {
        return "("+e.a+"+"+e.b+")";
    }

    @Override
    public String visit(Subtract e) {
        return "("+e.a+"-"+e.b+")";
    }

    @Override
    public String visit(Multiply e) {
        return "("+e.a+"*"+e.b+")";
    }
}

//新增

interface ExpVisitor2<T> extends ExpVisitor<T> {
    T visit(Divide d);
}

class ExpEvalVisitor2 extends ExpEvalVisitor implements ExpVisitor2<Integer> {
    @Override
    public Integer visit(Divide d) {
        return d.a/d.b;
    }
}

interface Exp2 {
    <T> T accept(ExpVisitor2<T> visitor);
}

class Divide implements Exp2 {
    public final int a;
    public final int b;

    public Divide(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor2<T> visitor) {
        return visitor.visit(this);
    }
}

//新增

class Divide2 extends Divide implements Exp {
    public final int a;
    public final int b;

    public Divide2(int a, int b) {
        super(a,b);

        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return ((ExpVisitor2<T>) visitor).visit(this);
    }
}

class Main{
    public static void main(String[] args) {
        Exp exp1 = new Add(1, 2);
        int res2 = exp1.accept(new ExpEvalVisitor());
        System.out.println(res2);
        String res3 = exp1.accept(new ExpShowVisitor());
        System.out.println(res3);
    }
}