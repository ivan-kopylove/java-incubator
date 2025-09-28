package heap.a27f;

import org.junit.jupiter.api.Test;

/// java.mechanics.exceptions.nestedclasses
class Runner
{
    @Test
    void haveToWrapWithTry()
    {
        Parent sut = new Child();
        sut.run();
    }

    @Test
    void dontHaveToWrapWithTry()
    {
        Child sut = new Child();
        sut.run();
    }
}
