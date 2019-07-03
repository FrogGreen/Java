//Spring - Java Annotations Configuration - Bean Lifecycle

package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring - Java Annotations Configuration - Bean Lifecycle.xml");

        //Retrieve bean
        Supervisor alphaSupervisor = context.getBean("personalSupervisor", Supervisor.class);
        Supervisor bravoSupervisor = context.getBean("personalSupervisor", Supervisor.class);
        Supervisor charlieSupervisor = context.getBean("publicSupervisor", Supervisor.class);
        Supervisor deltaSupervisor = context.getBean("publicSupervisor", Supervisor.class);

        //Singleton scope
        System.out.println("Singleton scope:");
        System.out.println("Alpha location in memory: " + alphaSupervisor);
        System.out.println("Bravo location in memory: " + bravoSupervisor);
        System.out.println("Daily routine from alpha: " + alphaSupervisor.getRoutine());
        System.out.println("Daily task from bravo: " + bravoSupervisor.getTask());

        //Prototype scope
        System.out.println("\nPrototype scope:");
        System.out.println("Charlie location in memory: " + charlieSupervisor);
        System.out.println("Delta location in memory: " + deltaSupervisor);
        System.out.println("Email to charlie: " + charlieSupervisor.getEmailAddress());
        System.out.println("Title of delta: " + deltaSupervisor.getTitle());

        //Close the context
        context.close();
    }
}