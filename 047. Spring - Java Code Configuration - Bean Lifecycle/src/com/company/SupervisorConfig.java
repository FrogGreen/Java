package com.company;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.company")
@PropertySource("classpath:Spring - Java Code Configuration - Bean Lifecycle")
public class SupervisorConfig {

    @Bean
    public WeeklyRoutine weeklyRoutine() {
        return new WeeklyRoutine();
    }

    @Bean
    @Scope("prototype")
    public Supervisor publicSupervisor() {
        return new PublicSupervisor(weeklyRoutine());
    }
}