package heap.a1ed;

import org.junit.jupiter.api.Test;

import heap.qweqweweqweq.TestBase;
class PlusOperationBetweenClassesTest extends TestBase
{

    @Test
    void exercise_design_reverse_engineering_example()
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
