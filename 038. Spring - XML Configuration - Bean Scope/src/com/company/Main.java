//Spring - XML Configuration - Bean Scope

package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring - XML Configuration - Bean Scope.xml");

        //Retrieve bean
        Supervisor alphaSupervisor = context.getBean("mySupervisor", Supervisor.class);
        Supervisor bravoSupervisor = context.getBean("mySupervisor", Supervisor.class);
        Supervisor charlieSupervisor = context.getBean("yourSupervisor", Supervisor.class);
        Supervisor deltaSupervisor = context.getBean("yourSupervisor", Supervisor.class);

        //Check if it is the same
        boolean result;

        //Singleton scope
        System.out.println("Singleton scope:");
        result = (alphaSupervisor == bravoSupervisor);
        System.out.println("Alpha and Bravo refer to the same object: " + result);
        System.out.println("Alpha location in memory: " + alphaSupervisor);
        System.out.println("Bravo location in memory: " + bravoSupervisor);

        //Prototype scope
        System.out.println("\nPrototype scope:");
        result = (charlieSupervisor == deltaSupervisor);
        System.out.println("Charlie and Delta refer to the same object: " + result);
        System.out.println("Charlie location in memory: " + charlieSupervisor);
        System.out.println("Delta location in memory: " + deltaSupervisor);

        //Close the context
        context.close();
    }
}