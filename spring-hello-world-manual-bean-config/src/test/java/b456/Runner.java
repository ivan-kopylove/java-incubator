package b456;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner
{
    @Test
    void what_will_be_printed()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyService service = context.getBean(MyService.class);

        System.out.println(service.getMessage());
    }
}
