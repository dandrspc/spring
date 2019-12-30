package me.dapac.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorldConfig {

    @Bean
    public World world() {
        return new World();
    }

}
