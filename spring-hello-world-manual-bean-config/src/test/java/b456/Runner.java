package b456;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner
{
    @Test
    void exercise_reverse_engineering_design()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyService service = context.getBean(MyService.class);

        System.out.println(service.getMessage());
    }
}
