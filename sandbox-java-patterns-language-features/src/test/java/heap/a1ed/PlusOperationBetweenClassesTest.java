package heap.a1ed;

import org.junit.jupiter.api.Test;

class PlusOperationBetweenClassesTest
{

    @Test
    void should_result_in_compilation_error_when_uncommented()
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
