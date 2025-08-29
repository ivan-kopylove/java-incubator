package heap.a968;

import org.junit.jupiter.api.Test;

import static heap.a968.MyClass.VALUE;
import static heap.a968.MyClass.myMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * static members example
 */
class AccessStaticMemberWithNull1486Test
{
    @Test
    void should_run_smoothly_even_class_is_nulled_before_usage()
    {
        MyClass myClass = new MyClass();
        myClass = null;

        assertEquals("some value", VALUE);
        assertEquals("some text", myMethod());
    }
}
