package com.company;

public class Singleton {//立即加载
    private String name;

    private Singleton(){}

    public static final Singleton INSTANCE = new Singleton();

    public void print(){
        System.out.println("singleton");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Singleton2{//立即加载
    private String name;

    private Singleton2(){}

    private static final Singleton2 INSTANCE = new Singleton2();
    public static Singleton2 getInstance(){
        return INSTANCE;
    }

    public void print(){
        System.out.println("singleton");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Singleton3{//延迟加载
    private String name;

    private Singleton3(){}

    private static class LazyHolder{
        private static final Singleton3 INSTANCE = new Singleton3();
    }
    public static Singleton3 getInstance(){//要不要在static 后面加final
        return LazyHolder.INSTANCE;
    }

    public void print(){
        System.out.println("singleton");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

enum Singleton4{//延迟加载
    INSTANCE;

    private String name;

    public void print(){
        System.out.println("singleton");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Singleton5{//延迟加载
    private String name;

    private Singleton5(){}

    private static volatile Singleton5 instance;

    public static Singleton5 getInstance(){
        if(instance == null){
            synchronized(Singleton5.class){
                if(instance==null){
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

    public void print(){
        System.out.println("singleton");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}