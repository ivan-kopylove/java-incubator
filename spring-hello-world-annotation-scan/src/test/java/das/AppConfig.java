// com.example.AppConfig.java
package das;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "das" // tried specifying non-existing package and running it
        , ""})
public class AppConfig {

}