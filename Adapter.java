//让一个类实现另一个接口


//下面的设计模式
//是对象适配器模式

//还有另一种是类适配器模式
class Power220V{
    void provide220V(){
        System.out.println("提供220V");
    }
}

interface Power5V{
    void provide5V();
    void anotherFunc();
}

public class Adapter implements Power5V{
    private Power220V power220V;

    public Adapter(Power220V power220V) {
        this.power220V = power220V;
    }

    @Override
    public void provide5V() {
        System.out.println("提供5V");
    }

    @Override
    public void anotherFunc() {
        System.out.println("其他功能");
    }
}

class Main{
    public static void main(String[] args){
        Power5V adapter = new Adapter(new Power220V());
        adapter.provide5V();
        adapter.anotherFunc();
    }
}
