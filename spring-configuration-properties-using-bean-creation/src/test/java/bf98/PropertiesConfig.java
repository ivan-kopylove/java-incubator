package bf98;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig
{
    @Bean
    MyProperties02 myProperties(){
        return new MyProperties02();
    }

}
