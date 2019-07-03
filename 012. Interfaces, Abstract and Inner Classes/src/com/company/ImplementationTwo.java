package com.company;

public class ImplementationTwo extends ImplementationOne implements InterfaceOne, InterfaceTwo {

    String interfaceTwo = "We can also override constant variables";

    @Override
    void ImplementationOne() {
        System.out.println(interfaceOne);
        System.out.println(interfaceTwo + "\n");
    }

    @Override
    public void print1() {
        System.out.println("Implementation Two - > If we have default and abstract method, we have to override it, becaue we have to implement abstract");
    }

    @Override
    public void print2() {
        System.out.println("Implementation Two - > If we have two default method, we have to override it, becaue we have to decide which one is the most important");
    }

    public void print4() {
        System.out.println("Implementation Two - > We have two static method");
    }

    public void print5() {
        System.out.println("Implementation Two - > We have static and abstract method");
    }

    public void print8() {
        InterfaceOne.print4();
        InterfaceTwo.print3();
        InterfaceTwo.print4();
        InterfaceTwo.print5();
    }

    class ImplementationThree {
        public void ImplementantionThree() {
            System.out.println("We can have class in class, that call inner class");
        }
    }
}
