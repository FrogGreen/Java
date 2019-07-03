package com.company;

public interface InterfaceOne {

    String interfaceOne = "InterfaceOne - > Interface allow to have constant variables";

    private String interfaceOne() {
        return interfaceOne;
    }

    default void print1() {
        System.out.println("InterfaceOne - > This is the different between DEFAULT and abstract method");
    }

    default void print2() {
        System.out.println("InterfaceOne - > This is the different between DEFAULT and default");
    }

    default void print3() {
        System.out.println("InterfaceOne - > This is the different between DEFAULT and static");
    }

    static void print4() {
        System.out.println("InterfaceOne - > This is the different between STATIC and static");
    }

    default void print6() {
        System.out.println(interfaceOne());
        print1();
        print2();
        print3();
        print4();
    }
}
