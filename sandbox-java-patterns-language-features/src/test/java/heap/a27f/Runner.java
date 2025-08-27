package heap.a27f;

import org.junit.jupiter.api.Test;

/**
 * java.mechanics.exceptions.nestedclasses
 */
class Runner
{
    @Test
    void haveToWrapWithTry()
    {
        Parent b = new Child();
        try
        {
            b.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void dontHaveToWrapWithTry()
    {
        Child b = new Child();
        b.run();
    }
}
