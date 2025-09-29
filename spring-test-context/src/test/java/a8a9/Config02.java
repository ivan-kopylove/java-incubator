package a8a9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class Config02
{
    
    @Bean
    public String message() {
        return "Hello from Config02";
    }
}

@Configuration
class Config01
{

    @Bean
    public String message() {
        return "Hello from Config01";
    }
}