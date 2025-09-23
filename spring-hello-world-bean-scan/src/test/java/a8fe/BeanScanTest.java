package a8fe;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScanTest
{
    @Test
    void what_will_be_printed()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        SomeService1 service = context.getBean(SomeService1.class);

        System.out.println(service.getMessage());
    }
}
