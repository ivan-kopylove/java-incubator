package heap.a3c5;

class MyNotClonableObj
{
    private final String field = "value";

    String getField()
    {
        return field;
    }

    Object get() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
