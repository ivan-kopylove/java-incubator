package heap.a1ed;

import org.junit.jupiter.api.Test;

class PlusOperationBetweenClassesTest
{

    @Test
    void exercise_reverse_engineering_design_example()
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
