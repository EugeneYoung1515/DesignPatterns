//命令模式
//A调用B B调用C
//B是个接口 由B的不同实现类去调用C
//B就是命令

//thread就相当于A Runnable相当于B Runnable的实现类有指向其他类C的引用变量做实例变量 调用Runnable的方法进而调用C的方法


class Receiver{
    public void action(){
        System.out.println("命令的真正执行者是 Receiver类的对象");
    }
}

public interface Command {
    void run();
}

class MyCommand implements Command{
    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void run() {
        receiver.action();
    }
}

class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.run();
    }
}

class Main{//也就是相当于 客户端的角色 Client
    public static void main(String[] args){
        Command command = new MyCommand(new Receiver());
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
