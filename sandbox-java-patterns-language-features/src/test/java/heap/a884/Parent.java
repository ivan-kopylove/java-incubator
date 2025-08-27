package heap.a884;

import java.util.ArrayList;
import java.util.List;

class Parent
{
    private final List<Parent> list = new ArrayList<>();

    public List<Parent> getList()
    {
        return list;
    }

    public void addValue(Parent value)
    {
        list.add(value);
    }
}
