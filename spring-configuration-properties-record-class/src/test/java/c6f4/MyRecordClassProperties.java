package c6f4;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
record MyRecordClassProperties(String myName, String yourName)
{

}
