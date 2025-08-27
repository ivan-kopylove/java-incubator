package heap.ac56;

class Child extends Parent
{
    public static String getValue() // hides Parent.getValue()
    {
        return "child";
    }
}
