//门面模式或者说外观模式

//门面模式是对象的结构模式，外部与一个子系统的通信必须通过一个统一的门面对象进行。门面模式提供一个高层次的接口，使得子系统更易于使用。
/*
1.当你要为一个复杂子系统提供一个简单接口时。子系统往往因为不断演化而变得越来越
复杂。大多数模式使用时都会产生更多更小的类。这使得子系统更具可重用性，也更容
易对子系统进行定制，但这也给那些不需要定制子系统的用户带来一些使用上的困难。
Facade可以提供一个简单的缺省视图，这一视图对大多数用户来说已经足够，而那些需
要更多的可定制性的用户可以越过facade层。
 */
class ModuleA{
    public void serviceA(){
        System.out.println("serviceA");
    }
}

class ModuleB{
    public void serviceB(){
        System.out.println("serviceB");
    }
}

class ModuleC{
    public void serviceC(){
        System.out.println("serviceC");
    }
}

public class Facade {//Facade这个类 也可以换成一个接口的实现类
    public void service() {
        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();
        //上面这三个 也可以挪到实例变量那里
        //再加上接口引用指向实现类对象

        moduleA.serviceA();
        moduleB.serviceB();
        moduleC.serviceC();
    }
}

class Test{
    public static void main(String[] args){
        Facade facade = new Facade();
        facade.service();
    }
}
