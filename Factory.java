interface ProductA{
    void process();
}
class ProductA1 implements ProductA{
    @Override
    public void process() {
        System.out.println("A1process");
    }
}

class ProductA2 implements ProductA{
    @Override
    public void process() {
        System.out.println("A2process");
    }
}
interface ProductB{
    void work();
}

class ProductB1 implements ProductB{
    @Override
    public void work() {
        System.out.println("B1work");
    }
}

class ProductB2 implements ProductB{
    @Override
    public void work() {
        System.out.println("B2work");
    }
}

public class Factory {//简单工厂

    public ProductA make(String name){
        if(name.equals("A1")){
            return new ProductA1();
        }else if(name.equals("A2")){
            return new ProductA2();
        }else{
            return null;
        }
    }
}
class Factory2{//静态工厂
    public static ProductA make(String name){
        if(name.equals("A1")){
            return new ProductA1();
        }else if(name.equals("A2")){
            return new ProductA2();
        }else{
            return null;
        }
    }
}
interface Factory3{//普通工厂
    ProductA make();
}

class A1Factory3 implements Factory3{
    @Override
    public ProductA make() {
        return new ProductA1();
    }
}

class A2Factory3 implements Factory3{
    @Override
    public ProductA make() {
        return new ProductA2();
    }
}

interface Factory4{//抽象工厂
    ProductA makeProductA();
    ProductB makeProductB();
}

class FirstFactory4 implements Factory4{
    @Override
    public ProductA makeProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB makeProductB() {
        return new ProductB1();
    }
}

class SecondFactory4 implements Factory4{
    @Override
    public ProductA makeProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB makeProductB() {
        return new ProductB2();
    }
}

class Main{
    public static void main(String[] args){
        Factory factory = new Factory();
        ProductA productA1 = factory.make("A1");
        productA1.process();

        productA1 = Factory2.make("A2");
        productA1.process();

        Factory3 A1Factory3 = new A1Factory3();
        productA1 = A1Factory3.make();
        productA1.process();
        Factory3 A2Factory3 = new A2Factory3();
        ProductA productA2 = A2Factory3.make();
        productA2.process();

        Factory4 firstFactory = new FirstFactory4();
        productA1 = firstFactory.makeProductA();
        productA1.process();
        Factory4 secondFactory = new SecondFactory4();
        ProductB productB2 = secondFactory.makeProductB();
        productB2.work();
    }
}
