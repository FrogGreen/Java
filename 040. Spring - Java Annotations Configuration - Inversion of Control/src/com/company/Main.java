//Spring - Java Annotations Configuration - Inversion of Control

package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //Load spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring - Java Annotations Configuration - Inversion of Control.xml");

        //Retrieve bean
        Supervisor alphaSupervisor = context.getBean("personalSupervisor", Supervisor.class);

        //Call method on bean
        System.out.println(alphaSupervisor.getTask());

        //Close the context
        context.close();
    }
}