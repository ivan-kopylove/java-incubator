package a8a9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConfig {
    
    @Bean
    public String message() {
        return "Hello from SecondConfig";
    }
}