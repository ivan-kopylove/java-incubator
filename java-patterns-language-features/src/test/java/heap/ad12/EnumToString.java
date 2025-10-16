package heap.ad12;

enum EnumToString
{
    MY_VALUE("QWERTY");

    private final String enumValue;

    EnumToString(String enumValue)
    {
        this.enumValue = enumValue;
    }

    String getEnumValue()
    {
        return enumValue;
    }
}
