// com.example.AppConfig.java
package b456;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class AppConfig {

    @Bean
     MyService myService() {
        return new MyService();
    }
}