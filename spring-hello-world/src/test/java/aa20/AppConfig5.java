// com.example.AppConfig5.java
package aa20;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class AppConfig5
{

    @Bean
     MyService5 myService() {
        return new MyService5();
    }
}