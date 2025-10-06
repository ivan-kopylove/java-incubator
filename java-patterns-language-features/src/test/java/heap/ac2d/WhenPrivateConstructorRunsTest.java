package heap.ac2d;

import org.junit.jupiter.api.Test;

import static heap.ac2d.PrivateConstructorClass.privateConstructorClass;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.ivan.kopylove.commons.testing.TestBase;
class WhenPrivateConstructorRunsTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering_me_in_debug_mode()
    {
        String value = PrivateConstructorClass.getValue();
        assertEquals("put a breakpoint here", value);
    }

    @Test
    void exercise_design_reverse_engineering_me_in_debug_mode2()
    {
        String input = "my custom value";

        PrivateConstructorClass myClass = privateConstructorClass(input);
        assertEquals(input, myClass.getMyString());
    }
}
