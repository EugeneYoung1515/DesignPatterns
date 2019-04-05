//使用桥接模式 处理多维度的问题
//使用继承或者实现的话 四个品牌 三种模式
//就需要4*3=12种子类
//使用桥接模式
//从两个维度看
//就只需要4+3=7种java类

import java.util.concurrent.Callable;

interface Mode{
    void mode();
}

class Auto implements Mode{
    @Override
    public void mode() {
        System.out.println("自动模式");
    }
}

class Hand implements Mode{
    @Override
    public void mode() {
        System.out.println("手动模式");
    }
}

class Mix implements Mode{
    @Override
    public void mode() {
        System.out.println("混合模式");
    }
}

abstract class Car{
    private Mode mode;

    public Car(Mode mode) {
        this.mode = mode;
    }

    //public abstract void run();

    public void run(){
        mode.mode();
    }
}

class CarA extends Car{
    public CarA(Mode mode) {
        super(mode);
    }

    @Override
    public void run() {
        System.out.print("品牌A");
        super.run();
    }
}
class CarB extends Car{
    public CarB(Mode mode) {
        super(mode);
    }

    @Override
    public void run() {
        System.out.print("品牌B");
        super.run();
    }
}

class CarC extends Car{
    public CarC(Mode mode) {
        super(mode);
    }

    @Override
    public void run() {
        System.out.print("品牌C");
        super.run();
    }
}

class CarD extends Car{
    public CarD(Mode mode) {
        super(mode);
    }

    @Override
    public void run() {
        System.out.print("品牌D");
        super.run();
    }
}

public class Bridge {

    public static void main(String[] args){
        Mode mode1 = new Auto();
        Mode mode2 = new Hand();
        Car carAAuto = new CarA(mode1);
        Car carBHand = new CarB(mode2);//或者使得Car有setter方法能够传入Mode实现类对象
        carAAuto.run();
        carBHand.run();
    }
}
