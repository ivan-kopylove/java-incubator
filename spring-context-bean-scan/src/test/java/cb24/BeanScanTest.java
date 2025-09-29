package cb24;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScanTest
{
    @Test
    void exercise_design_reverse_engineering()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        SomeService1 service = context.getBean(SomeService1.class);

        System.out.println(service.getMessage());
    }
}
