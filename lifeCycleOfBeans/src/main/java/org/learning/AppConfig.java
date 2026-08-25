package org.learning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean(initMethod = "start")
    public cartService getCartBean(){
        return  new cartService();

    }
}
