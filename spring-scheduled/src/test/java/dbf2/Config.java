package dbf2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
class Config
{
    @Bean
    MySchedulableService MySchedulableService1()
    {
        return new MySchedulableService();
    }

    @Bean
    MySchedulableService2 MySchedulableService2()
    {
        return new MySchedulableService2();
    }
}