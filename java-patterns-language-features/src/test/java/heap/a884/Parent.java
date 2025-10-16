package heap.a884;

import java.util.ArrayList;
import java.util.List;

class Parent
{
    private final List<Parent> list = new ArrayList<>();

    List<Parent> getList()
    {
        return list;
    }

    void addValue(Parent value)
    {
        list.add(value);
    }
}
