package a8fe;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ManualBeanConfigTest
{
    @Test
    void exercise_reverse_engineering_design()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);

        MyCacheableService2 service = context.getBean(MyCacheableService2.class);

        System.out.println(service.generateUuid(1));
        System.out.println(service.generateUuid(1));

        assertThat(service.generateUuid(1), equalTo(service.generateUuid(1)));
        assertThat(service.generateUuid(1), equalTo(service.generateUuid(1)));
    }
}
