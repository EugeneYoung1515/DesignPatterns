package third.second;

public interface Exp<T> {
     T literal(int v);
     T add(T a, T b);
     T subtract(T a, T b);
     T multiply(T a, T b);
}

class Eval implements Exp<Integer> {
    @Override
    public Integer literal(int v) {
        return v;
    }
    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
    @Override
    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }
    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }
}

//新增
class Show implements Exp<String> {
    @Override
    public String literal(int v) {
        return v + "";
    }

    @Override
    public String add(String a, String b) {
        return "(" + a + "+" + b + ")";
    }

    @Override
    public String subtract(String a, String b) {
        return "(" + a + "-" + b + ")";
    }

    @Override
    public String multiply(String a, String b) {
        return "(" + a + "*" + b + ")";
    }
}


//新增
interface DExp<T> extends Exp<T> {
     T divide(T a, T b);
}

class DEval extends Eval implements DExp<Integer> {
    @Override
    public Integer divide(Integer a, Integer b) {
        return a / b;
    }
}

class Main{
    public static void main(String[] args) {
        DEval de = new DEval();
        int res2 = de.divide(de.add(de.literal(1), de.literal(2)), de.literal(3));
        System.out.println(res2);
    }
}

