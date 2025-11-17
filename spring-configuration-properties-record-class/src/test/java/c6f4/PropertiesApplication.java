package c6f4;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(ParticularProperties.class) or ConfigurationPropertiesScan
@ConfigurationPropertiesScan
public class PropertiesApplication
{


}