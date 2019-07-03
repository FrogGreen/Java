//Spring - Java Code Configuration - Inversion of Control

package com.company;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Load spring configuration java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SupervisorConfig.class);

        //Retrieve bean
        Supervisor alphaSupervisor = context.getBean("personalSupervisor", Supervisor.class);

        //Call method on bean
        System.out.println(alphaSupervisor.getTask());

        //Close the context
        context.close();
    }
}