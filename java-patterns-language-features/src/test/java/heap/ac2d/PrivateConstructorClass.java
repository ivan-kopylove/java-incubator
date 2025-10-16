package heap.ac2d;

class PrivateConstructorClass
{
    private static String value = "initial value";

    static
    {
        value = "put a breakpoint here";
    }

    private String myString = "field initial value";

    private PrivateConstructorClass(String myString)
    {
        this.myString = myString;
        value = "and put a breakpoint here as well";
    }

    static PrivateConstructorClass privateConstructorClass(String myString)
    {
        return new PrivateConstructorClass(myString);
    }

    static String getValue()
    {
        return value;
    }

    String getMyString()
    {
        return myString;
    }
}
