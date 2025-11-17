package d1d4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class MyProperties01
{
    private String myName;
    private String yourName;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getYourName()
    {
        return yourName;
    }

    public void setYourName(String yourName)
    {
        this.yourName = yourName;
    }
}
