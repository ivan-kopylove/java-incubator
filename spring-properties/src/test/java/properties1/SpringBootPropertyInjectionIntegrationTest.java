package properties1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = Config.class)
class SpringBootPropertyInjectionIntegrationTest
{

    @Value("${foo.bar}")
    private String baz;

    @Value("${foo.myPropertyOne}")
    private String myPropertyOne;

    @Test
    void whenSpringBootPropertyProvided_thenProperlyInjected()
    {
        assertThat(baz).isEqualTo("baz");
        assertThat(myPropertyOne).isEqualTo("baq");
    }
}

@Configuration
@ComponentScan(basePackages = {"properties1"}) // tried specifying non-existing package and running it
class Config
{

}

@Component
class AppContextRefreshedEventPropertiesPrinter
{

    @EventListener
    void handleContextRefreshed(ContextRefreshedEvent event)
    {
        ConfigurableEnvironment env = (ConfigurableEnvironment) event.getApplicationContext()
                                                                     .getEnvironment();

        env.getPropertySources()
           .stream()
           .filter(ps -> ps instanceof MapPropertySource)
           .map(ps -> ((MapPropertySource) ps).getSource()
                                              .keySet())
           .flatMap(Collection::stream)
           .distinct()
           .sorted()
           .forEach(key -> System.out.println(key + " = " + env.getProperty(key)));
    }
}