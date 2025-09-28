package heap.ac56;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.ivan.kopylove.commons.testing.TestBase;
class MethodHidingOnStaticClassMethodsTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        Child1 child = new Child1();

        assertEquals("child", Child1.getValue());
        assertEquals("parent", Child2.getValue());
        assertEquals("parent", Parent.getValue());
    }
}
