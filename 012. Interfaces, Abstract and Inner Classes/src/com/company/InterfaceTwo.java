package com.company;

public interface InterfaceTwo {

    String interfaceTwo = "InterfaceTwo - > Interface allow to have constant variables";

    private String interfaceTwo() {
        return "InterfaceTwo - > We can use interface method as private";
    }

    void print1();

    default void print2() {
        System.out.println("InterfaceTwo - > This is the different between default and DEFAULT");
    }

    static void print3() {
        System.out.println("InterfaceTwo - > This is the different between default and STATIC");
    }

    static void print4() {
        System.out.println("InterfaceTwo - > This is the different between static and STATIC");
    }

    static void print5() {
        System.out.println("InterfaceTwo - > This is the different between abstract and STATIC");
    }

    default void print7() {
        System.out.println(interfaceTwo());
        print1();
        print2();
        print3();
        print4();
        print5();
    }
}
