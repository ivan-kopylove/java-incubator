package heap.a27f;

import org.junit.jupiter.api.Test;

class Runner
{
    @Test
    void dontHaveToWrapWithTry()
    {
        Child sut = new Child();
        sut.myMethod();
    }
}
