package a88b;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config02.class)
class Config02Test
{
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void exercise_design_reverse_engineering()
    {
        String message = applicationContext.getBean(String.class);

        assertThat(message, equalTo("Hello from Config02"));
    }
}

@Configuration
class Config02
{
    @Bean
    String message()
    {
        return "Hello from Config02";
    }
}