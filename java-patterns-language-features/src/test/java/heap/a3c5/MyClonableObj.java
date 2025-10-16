package heap.a3c5;

class MyClonableObj implements Cloneable
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
