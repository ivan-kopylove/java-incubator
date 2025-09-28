package a8a9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SecondConfig.class)
public class SecondConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void exercise_design_reverse_engineering() {
        String message = applicationContext.getBean(String.class);
        assertThat(message, equalTo("Hello from SecondConfig"));
    }
}