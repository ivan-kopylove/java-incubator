package heap.a39b.example1;

import java.util.HashMap;
import java.util.Map;

/// java.mechanics.oop.overriding.example
class Base
{
    public <T extends Number, Z extends Number> Map<T, Z> getMap(T t, Z z)
    {
        return new HashMap<T, Z>();
    }
}
