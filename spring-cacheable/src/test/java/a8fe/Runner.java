package a8fe;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Runner
{
    @Test
    void what_will_be_printed()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SomeService service = context.getBean(SomeService.class);

        System.out.println(service.generateUuid(1));
        System.out.println(service.generateUuid(1));

        assertThat(service.generateUuid(1), equalTo(service.generateUuid(1)));
        assertThat(service.generateUuid(1), equalTo(service.generateUuid(1)));
    }
}
