package aa01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
 class FirstConfig {

    @Bean
    MyService myService() {
        return new MyService();
    }
}

@Configuration
 class SecondConfig
{
    @Bean
    MyService myService() {
        return new MyService();
    }
}