package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonalSupervisor implements Supervisor {

    private Routine routine;
    private String title;
    private String emailAddress;

    public PersonalSupervisor() {
    }

    @Autowired
    public PersonalSupervisor(@Qualifier("dailyRoutine")Routine routine) {
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

    public void justStart() {
        System.out.println("PersonalSupervisor: Let's start " + this + "!");
    }

    public void justStop() {
        System.out.println("PersonalSupervisor: Let's stop " + this + "!");
    }
}