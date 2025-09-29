// com.example.AppConfig1.java
package cb24;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"cb24"} ) // tried specifying non-existing package and running it
public class AppConfig1
{

}