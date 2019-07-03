package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class PublicSupervisor implements Supervisor {

    private Routine routine;
    private String title;
    private String emailAddress;

    public PublicSupervisor() {
    }

    @Autowired
    public PublicSupervisor(@Qualifier("weeklyRoutine") Routine routine) {
        this.routine = routine;
    }

    public String getTitle() {
        return title;
    }

    @Value("Boss")
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    @Value("${foo.emailAddress}")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String getTask() {
        return "This is your task!";
    }

    @Override
    public String getRoutine() {
        return "This is your routine: " + routine.getRoutine();
    }

    @PostConstruct
    public void justStart() {
        System.out.println("PublicSupervisor: Let's start " + this + "!");
    }

    @PreDestroy
    public void justStop() {
        System.out.println("PublicSupervisor: Let's stop " + this + "!");
    }
}