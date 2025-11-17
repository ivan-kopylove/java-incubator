package bf98;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class MyProperties02
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
