package heap.a3c5;

class MyNotClonableObj
{
    private final String field = "value";

    public String getField()
    {
        return field;
    }

    public Object get() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
