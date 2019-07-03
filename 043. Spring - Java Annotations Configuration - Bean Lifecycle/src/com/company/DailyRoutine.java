package com.company;

import org.springframework.stereotype.Component;

@Component
public class DailyRoutine implements Routine {

    @Override
    public String getRoutine() {
        return "Daily routine!";
    }
}