package d1d2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Configs
{
    @Bean
    String someBean()
    {
        return "myBean123";
    }
}

