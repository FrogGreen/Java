package com.company;

import org.springframework.stereotype.Component;

@Component
public class WeeklyRoutine implements Routine {

    @Override
    public String getRoutine() {
        return "Weekly routine!";
    }
}