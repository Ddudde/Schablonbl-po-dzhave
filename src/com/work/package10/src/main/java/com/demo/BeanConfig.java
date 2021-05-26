package com.demo;

import org.springframework.context.annotation.Bean;

public class BeanConfig {
    @Bean
    public Lighter dam1() {
        return new Lamp();
    }

    @Bean
    public Lighter dam2() {
        return new Flashlight();
    }

    @Bean
    public Lighter dam3() {
        return new Firefly();
    }
}
