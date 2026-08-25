package org.learning;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.learning")
public class appConfig {
    // empty here we create all the object using @bean which create bean in class
}
