//实际上是静态代理

interface ObjectInterface{
    void operate();
}

class RealObject implements ObjectInterface{
    @Override
    public void operate() {
        System.out.println("work");
    }
}

class ProxyObject implements ObjectInterface{
    private ObjectInterface realObject = new RealObject();
    //这个实例变量如果换成构造函数传进来 就和 装饰模式很像

    @Override
    public void operate() {
        System.out.println("Before");
        realObject.operate();
        System.out.println("After");
    }
}

public class Proxy {
    public static void main(String[] args){
        ObjectInterface proxy = new ProxyObject();
        proxy.operate();
    }
}
