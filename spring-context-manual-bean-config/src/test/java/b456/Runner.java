package b456;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 class Runner
{
    @Test
    void exercise_design_reverse_engineering()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyService service = context.getBean(MyService.class);

        System.out.println(service.getMessage());
    }
}
