package third.first;

public interface ExpVisitor<T> {

    T forLiteral(Literal e);

    T forAdd(Add e);

    T forSubtract(Subtract e);

    T forMultiply(Multiply e);
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
        return visitor.forLiteral(this);
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
        return visitor.forAdd(this);
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
        return visitor.forSubtract(this);
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
        return visitor.forMultiply(this);
    }
}

class ExpEvalVisitor implements ExpVisitor<Integer> {
    @Override
    public Integer forLiteral(Literal e) {
        return e.val;
    }

    @Override
    public Integer forAdd(Add e) {
        return e.a+e.b;
    }

    @Override
    public Integer forSubtract(Subtract e) {
        return e.a-e.b;
    }

    @Override
    public Integer forMultiply(Multiply e) {
        return e.a*e.b;
    }
}

//新增
class ExpShowVisitor implements ExpVisitor<String> {
    @Override
    public String forLiteral(Literal e) {
        return e.val+"";
    }

    @Override
    public String forAdd(Add e) {
        return "("+e.a+"+"+e.b+")";
    }

    @Override
    public String forSubtract(Subtract e) {
        return "("+e.a+"-"+e.b+")";
    }

    @Override
    public String forMultiply(Multiply e) {
        return "("+e.a+"*"+e.b+")";
    }
}

//新增

interface ExpVisitor2<T> extends ExpVisitor<T> {
    T forDivide(Divide d);
}

class ExpEvalVisitor2 extends ExpEvalVisitor implements ExpVisitor2<Integer> {
    @Override
    public Integer forDivide(Divide d) {
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
        return visitor.forDivide(this);
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
        return ((ExpVisitor2<T>) visitor).forDivide(this);
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