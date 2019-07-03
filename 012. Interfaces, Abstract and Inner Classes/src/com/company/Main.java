//Interfaces, Abstract and Inner Class

package com.company;

public class Main {

    public static void main(String[] args) {

        ImplementationTwo nameToTest1 = new ImplementationTwo();

        ImplementationTwo.ImplementationThree nameToTest2 = nameToTest1.new ImplementationThree();
        nameToTest2.ImplementantionThree();
        System.out.println();

        nameToTest1.ImplementationOne();

        System.out.print("Print1: ");
        nameToTest1.print1();
        System.out.print("Print2: ");
        nameToTest1.print2();
        System.out.print("Print3: ");
        nameToTest1.print3();
        System.out.print("Print4: ");
        nameToTest1.print4();
        System.out.print("Print5: ");
        nameToTest1.print5();

        System.out.print("\nPrint InterfaceOne: \n");
        nameToTest1.print6();

        System.out.print("\nPrint InterfaceTwo: \n");
        nameToTest1.print7();

        System.out.println("\nWe have also access to static method from interfaces in class:");
        nameToTest1.print8();

        System.out.println("\nWe have also access to variables in interfaces");
        System.out.println(((InterfaceOne) nameToTest1).interfaceOne);
        System.out.println(((InterfaceTwo) nameToTest1).interfaceTwo);

        System.out.println("\nWe have also access to default method in interfaces");
        System.out.println("InterfaceOne:");
        System.out.print("Print1: ");
        ((InterfaceOne) nameToTest1).print1();
        System.out.print("Print2: ");
        ((InterfaceOne) nameToTest1).print2();
        System.out.print("Print3: ");
        ((InterfaceOne) nameToTest1).print3();
        System.out.print("Print6: ");
        ((InterfaceOne) nameToTest1).print6();
        System.out.println("\nInterfaceTwo:");
        System.out.print("Print1: ");
        ((InterfaceTwo) nameToTest1).print1();
        System.out.print("Print2: ");
        ((InterfaceTwo) nameToTest1).print2();
        System.out.print("Print7: ");
        ((InterfaceTwo) nameToTest1).print7();
    }
}
