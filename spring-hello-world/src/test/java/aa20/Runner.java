package aa20;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 class Runner
{
    @Test
    void exercise_design_reverse_engineering()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig5.class);

        MyService5 service = context.getBean(MyService5.class);

        System.out.println(service.getMessage());
    }
}
