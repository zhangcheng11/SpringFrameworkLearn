package com.stone.spring.context.bean;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvironmentTest implements EnvironmentAware {
    private static Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        environment.getActiveProfiles()
    }
}
