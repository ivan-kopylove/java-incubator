package heap.ad12;

public enum EnumToString
{
    MY_VALUE("QWERTY");

    private final String enumValue;

    EnumToString(String enumValue)
    {
        this.enumValue = enumValue;
    }

    public String getEnumValue()
    {
        return enumValue;
    }
}
