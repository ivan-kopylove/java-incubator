package c56c;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class CachePutTest
{
    @Test
    void exercise_design_reverse_engineering()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);

        SomeService3 service = context.getBean(SomeService3.class);

        System.out.println(service.getClass()
                                  .getSimpleName()
                                  .toString());

        System.out.println(service.generateUuid(1));
        System.out.println(service.generateUuid(1));
        System.out.println(service.generateUuid2(1));

        assertThat(service.generateUuid(1), equalTo(service.generateUuid2(1)));
        assertThat(service.generateUuid(1), equalTo(service.generateUuid2(1)));
    }
}
