package me.dapac.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarsConfig {

    @Bean
    public World mars() {
        return new World();
    }
}
