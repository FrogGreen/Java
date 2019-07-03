//Spring - Java Annotations Configuration - Dependency Injection

package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring - Java Annotations Configuration - Dependency Injection.xml");

        //Retrieve bean
        Supervisor alphaSupervisor = context.getBean("personalSupervisor", Supervisor.class);

        //Call method on bean
        System.out.println(alphaSupervisor.getTask());
        System.out.println(alphaSupervisor.getRoutine());
        System.out.println(alphaSupervisor.getTitle());
        System.out.println(alphaSupervisor.getEmailAddress());

        //Close the context
        context.close();
    }
}