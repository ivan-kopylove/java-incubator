package heap.ac56;

class Child1 extends Parent
{
    public static String getValue() // hides Parent.getValue()
    {
        return "child";
    }
}
