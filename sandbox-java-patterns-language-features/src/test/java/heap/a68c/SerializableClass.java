package heap.a68c;

import java.io.Serializable;

class SerializableClass implements Serializable
{
    private static final long   serialVersionUID = 3L;
    private              String value            = "123";

    public SerializableClass(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
