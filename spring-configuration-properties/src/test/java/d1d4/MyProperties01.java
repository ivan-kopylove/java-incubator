package d1d4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
class MyProperties01
{
    private String myName;
    private String yourName;

    String getMyName() {
        return myName;
    }

    void setMyName(String myName) {
        this.myName = myName;
    }

    String getYourName()
    {
        return yourName;
    }

    void setYourName(String yourName)
    {
        this.yourName = yourName;
    }
}
