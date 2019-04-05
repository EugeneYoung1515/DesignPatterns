//状态模式和策略模式像

public interface State {
    void eat();
    void hangOut();
    void sleep();
}

class WifeState implements State{
    private Man man;

    public WifeState(Man man) {
        this.man = man;
    }

    @Override
    public void eat() {
        System.out.println("和老婆吃饭");
    }

    @Override
    public void hangOut() {
        System.out.println("和老婆逛街");
    }

    @Override
    public void sleep() {
        System.out.println("和老婆睡觉");
    }
}

class LoverState implements State{
    private Man man;

    public LoverState(Man man) {
        this.man = man;
    }

    @Override
    public void eat() {
        System.out.println("和情人睡觉");
    }

    @Override
    public void hangOut() {
        System.out.println("和情人逛街");
    }

    @Override
    public void sleep() {
        System.out.println("和情人睡觉");
        changeState();
    }

    public void changeState(){
        man.setState(new WifeState(man));
    }
}

class Man{//Man的状态是由State决定的
    private State state = new LoverState(this);
    public void eat(){
        state.eat();
    }
    public void hangOut(){
        state.hangOut();
    }
    public void sleep(){
        state.sleep();
    }
    public void setState(State state) {
        this.state = state;
    }
}

class Main{
    public static void main(String[] args){
        Man man = new Man();
        man.eat();
        man.hangOut();
        man.sleep();

        man.eat();
    }
}
/*
状态模式

        上下文对象Context 的所有方法依靠持有的状态类

        上下文提供切换状态的方法
        或者状态类提供切换到另一个状态的方法
        */