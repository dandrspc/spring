package me.dapac.beans;

import org.springframework.beans.factory.annotation.Value;

public class World {
    @Value("Hello World")
    private String greeting;

    public  World() {

    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
