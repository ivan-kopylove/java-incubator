package das;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner
{
    @Test
    void exercise_design_reverse_engineering()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SomeService service = context.getBean(SomeService.class);

        System.out.println(service.getMessage());
    }
}
