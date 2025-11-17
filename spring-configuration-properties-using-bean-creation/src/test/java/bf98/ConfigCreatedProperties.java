package bf98;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
class ConfigCreatedProperties
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
