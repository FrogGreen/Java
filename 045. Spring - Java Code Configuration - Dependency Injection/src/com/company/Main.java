//Spring - Java Code Configuration - Dependency Injection

package com.company;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Load the spring configuration java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SupervisorConfig.class);

        //Retrieve bean
        Supervisor alphaSupervisor = context.getBean("personalSupervisor", Supervisor.class);

        //Call method on bean
        System.out.println("alphaSupervisor bean:");
        System.out.println(alphaSupervisor.getTask());
        System.out.println(alphaSupervisor.getRoutine());
        System.out.println(alphaSupervisor.getTitle());
        System.out.println(alphaSupervisor.getEmailAddress());

        //Retrieve bean
        Supervisor bravoSupervisor = context.getBean("publicSupervisor", Supervisor.class);

        //Call method on bean
        System.out.println("\nbravoSupervisor bean:");
        System.out.println(bravoSupervisor.getTask());
        System.out.println(bravoSupervisor.getRoutine());
        System.out.println(bravoSupervisor.getTitle());
        System.out.println(bravoSupervisor.getEmailAddress());

        //Close the context
        context.close();
    }
}