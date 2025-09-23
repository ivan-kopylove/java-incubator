// com.example.AppConfig.java
package a8fe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"a8fe" // tried specifying non-existing package and running it
        , ""})
public class AppConfig {

}