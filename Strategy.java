//用策略模式替代if else

class Context{
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.run();
    }


    //public void setStrategy(Strategy strategy) {
        //this.strategy = strategy;
    //}
}

public interface Strategy {
    void run();
}

class StrategyA implements Strategy{
    @Override
    public void run() {
        System.out.println("得到一条毛巾");
    }
}

class StrategyB implements Strategy{

    @Override
    public void run(){
        System.out.println("得到一条牙膏");
    }
}

class Main{
    public static void main(String[] args){
        Context contextA = new Context(new StrategyA());
        contextA.execute();//选择了毛巾

        Context contextB = new Context(new StrategyB());
        contextB.execute();//选择了牙膏

        //如果选择了setter方法传入一个Strategy实现类对象
        //就能一个Context对象换不同的策略
        //但是重用之前的策略 就要setter回之前的Strategy
    }
}

class Price{
    private MemberStrategy memberStrategy;

    public Price(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public double quote(double originalPrice){
        return memberStrategy.calcPrice(originalPrice);
    }
}
interface MemberStrategy{
    double calcPrice(double originalPrice);
}

class PrimaryMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double originalPrice) {
        return originalPrice*0.9;
    }
}

class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double originalPrice) {
        return originalPrice*0.8;
    }
}

class AdvancedMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double originalPrice) {
        return originalPrice*0.7;
    }
}
class Client{
    public static void main(String[] args){
        Price primaryPrice = new Price(new PrimaryMemberStrategy());
        System.out.println(primaryPrice.quote(35.8));

        Price advancedPrice = new Price(new AdvancedMemberStrategy());
        System.out.println(advancedPrice.quote(35.8));

        //为什么不直接 MemberStrategy strategy = new PrimaryMemberStrategy
        //strategy.calc(...)
        //因为策略类不只有价格策略 还可以有其他策略 如礼物策略 积分策略
    }
}