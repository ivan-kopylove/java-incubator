package heap.a1ed;

import org.junit.jupiter.api.Test;

class PlusOperationBetweenClassesTest
{

    @Test
    void what_is_the_point_of_this_example()
    {
        //        System.out.println(new ClassOne() + new ClassTwo());
    }

    @Test
    void oneOfTheClassesIsStringNoCompileError()
    {
        System.out.println("My string " + new ClassTwo());
        System.out.println("My string " + new ClassTwo());
    }
}
