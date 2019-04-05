//装饰模式也就是包装模式 与代理模式这里指静态代理 的区别
//装饰模式 与责任链模式的区别

interface Waiter{
    void work();
    int salary();
}

class WaiterImpl implements Waiter{
    @Override
    public void work() {
        System.out.println("送饭");
    }

    @Override
    public int salary() {
        return 1500;
    }
}

class AccountWaiter implements Waiter{
    private Waiter waiter;
    public AccountWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void work() {
        System.out.println("记账");
        waiter.work();
    }

    @Override
    public int salary() {
        return 200+waiter.salary();
    }
}

class CookWaiter implements Waiter{
    private Waiter waiter;

    public CookWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void work() {
        System.out.println("做饭");
        waiter.work();
    }

    @Override
    public int salary() {
        return 1500+waiter.salary();
    }
}

public class Decorator {
    public static void main(String[] args){
        Waiter waiter = new CookWaiter(new AccountWaiter(new WaiterImpl()));
        waiter.work();
        System.out.println(waiter.salary());
    }
}
