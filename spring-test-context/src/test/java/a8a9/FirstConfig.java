package a8a9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstConfig {
    
    @Bean
    public String message() {
        return "Hello from FirstConfig";
    }
}