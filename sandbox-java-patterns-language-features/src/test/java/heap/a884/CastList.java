package heap.a884;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

/// [...](https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes)
class CastList
{
    @Test
    void foo()
    {
        Child child = new Child();
        child.addValue(new Child());
        child.addValue(new Child());

        List<Child> list = (List<Child>) (List<?>) child.getList();

        Iterator<Child> iterator = list.iterator();
    }
}