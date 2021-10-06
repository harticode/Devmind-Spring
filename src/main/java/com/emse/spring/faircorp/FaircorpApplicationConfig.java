package com.emse.spring.faircorp;


import com.emse.spring.faircorp.hello.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FaircorpApplicationConfig {
    // (2)
    @Bean
    public CommandLineRunner greetingCommandLine(GreetingService g) { // (3)
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // (4)
                g.greet("Spring");
                //
            }
        };
    }
}
