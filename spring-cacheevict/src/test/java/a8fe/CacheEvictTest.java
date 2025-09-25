package a8fe;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CacheEvictTest
{
    @Test
    void what_will_be_printed()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);

        SomeService3 service = context.getBean(SomeService3.class);

        System.out.println(service.associateMyArg(1));
        System.out.println(service.associateMyArg(1));
        service.evictMyCache(2);
        System.out.println(service.associateMyArg(1));
    }


    @Test
    void what_will_be_printed2()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);

        SomeService3 service = context.getBean(SomeService3.class);

        System.out.println(service.associateMyArg(3));
        System.out.println(service.associateMyArg(3));
        service.evictMyCache(3);
        System.out.println(service.associateMyArg(3));
    }



    @Test
    void what_will_be_printed3()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);

        SomeService3 service = context.getBean(SomeService3.class);

        System.out.println(service.associateMyArg(3));
        System.out.println(service.associateMyArg(3));
        service.evictMyCache();
        System.out.println(service.associateMyArg(3));
    }


    @Test
    void what_will_be_printed4()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig3.class);

        SomeService3 service = context.getBean(SomeService3.class);

        System.out.println(service.associateMyArg(3));
        System.out.println(service.associateMyArg(3));
        service.evictAllEntries();
        System.out.println(service.associateMyArg(3));
    }


}
