package bf98;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PropertiesConfig
{
    @Bean
    ConfigCreatedProperties myProperties(){
        return new ConfigCreatedProperties();
    }

}
