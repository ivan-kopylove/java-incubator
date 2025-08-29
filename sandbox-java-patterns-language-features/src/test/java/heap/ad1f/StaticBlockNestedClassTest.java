package heap.ad1f;

import org.junit.jupiter.api.Test;

class StaticBlockNestedClassTest
{

    @Test
    void foo()
    {
        System.out.println(Child.ID);
    }

    @Test
    void run2()
    {
        new Child();
    }
}

