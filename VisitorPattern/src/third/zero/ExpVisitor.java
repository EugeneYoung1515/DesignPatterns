package third.zero;

public interface ExpVisitor<T> {
    T forLiteral(int v);
    T forAdd(Exp a, Exp b);
    T forSubtract(Exp a, Exp b);
    T forMultiply(Exp a, Exp b);

    /*
    default T forLiteral(Literal e){
        return forLiteral(e.val);
    }
    default T forAdd(Add e){
        return forAdd(e.a,e.b);
    }
    default T forSubtract(Subtract e){
        return forSubtract(e.a,e.b);
    }
    default T forMultiply(Multiply e){
        return forMultiply(e.a,e.b);
    }
    */
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
        return visitor.forLiteral(val);

        //return visitor.forLiteral(this);
    }
}

class Add implements Exp {
    public final Exp a;
    public final Exp b;

    public Add(Exp a, Exp b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.forAdd(a, b);
    }
}

class Subtract implements Exp {
    public final Exp a;
    public final Exp b;

    public Subtract(Exp a, Exp b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.forSubtract(a, b);
    }
}

class Multiply implements Exp {
    public final Exp a;
    public final Exp b;

    public Multiply(Exp a, Exp b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return visitor.forMultiply(a, b);
    }
}

class ExpEvalVisitor implements ExpVisitor<Integer> {
    @Override
    public Integer forLiteral(int v) { return v; }
    @Override
    public Integer forAdd(Exp a, Exp b) { return a.accept(this) + b.accept(this); }
    @Override
    public Integer forSubtract(Exp a, Exp b) { return a.accept(this) - b.accept(this); }
    @Override
    public Integer forMultiply(Exp a, Exp b) { return a.accept(this) * b.accept(this); }
}

//新增
class ExpShowVisitor implements ExpVisitor<String> {
    @Override
    public String forLiteral(int v) { return v + ""; }
    @Override
    public String forAdd(Exp a, Exp b) { return "(" + a.accept(this) + "+" + b.accept(this) + ")"; }
    @Override
    public String forSubtract(Exp a, Exp b) { return "(" + a.accept(this) + "-" + b.accept(this) + ")"; }
    @Override
    public String forMultiply(Exp a, Exp b) { return "(" + a.accept(this) + "*" + b.accept(this) + ")"; }
}

//新增

interface ExpVisitor2<T> extends ExpVisitor<T> {
    T forDivide(Exp a, Exp b);
}

class ExpEvalVisitor2 extends ExpEvalVisitor implements ExpVisitor2<Integer> {
    @Override
    public Integer forDivide(Exp a, Exp b) {
        return a.accept(this)  / b.accept(this);
    }
}

interface Exp2 {
    <T> T accept(ExpVisitor2<T> visitor);
}

class Divide implements Exp2 {
    public final Exp a;
    public final Exp b;

    public Divide(Exp a, Exp b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor2<T> visitor) {
        return visitor.forDivide(a, b);
    }
}

//新增

class Divide2 implements Exp {
    public final Exp a;
    public final Exp b;

    public Divide2(Exp a, Exp b) {
        this.a = a;
        this.b = b;
    }

    public <T> T accept(ExpVisitor<T> visitor) {
        return ((ExpVisitor2<T>) visitor).forDivide(a, b);
    }
}

class Main{
    public static void main(String[] args) {
        Exp exp1 = new Add(new Literal(1), new Literal(2));
        int res2 = exp1.accept(new ExpEvalVisitor());
        System.out.println(res2);
        String res3 = exp1.accept(new ExpShowVisitor());
        System.out.println(res3);
    }
}