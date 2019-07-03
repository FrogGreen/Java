//Spring - Java Code Configuration - Bean Scope

package com.company;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Load the spring configuration java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SupervisorConfig.class);

        //Retrieve bean
        Supervisor alphaSupervisor = context.getBean("personalSupervisor", Supervisor.class);
        Supervisor bravoSupervisor = context.getBean("personalSupervisor", Supervisor.class);
        Supervisor charlieSupervisor = context.getBean("publicSupervisor", Supervisor.class);
        Supervisor deltaSupervisor = context.getBean("publicSupervisor", Supervisor.class);

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