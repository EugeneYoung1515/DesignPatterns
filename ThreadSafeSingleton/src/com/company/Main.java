package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Singleton4 singleton4 = Singleton4.INSTANCE;
        singleton4.print();
        singleton4.setName("test");
        System.out.println(singleton4.getName());

        Singleton5 singleton5 = Singleton5.getInstance();
        singleton5.print();

        singleton5.setName("test");
        System.out.println(singleton5.getName());
    }
}
