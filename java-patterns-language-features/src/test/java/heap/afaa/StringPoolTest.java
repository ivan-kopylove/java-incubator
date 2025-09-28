package heap.afaa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/// Basic demonstration of strings pool in java. Strings are compared intentionally using reference equality.
class StringPoolTest
{
    @Test
    void exercise_reverse_engineering_designExample()
    {
        // given
        String a = "Duke"; // all compile-time constant goes to a what place?
        String b = "Duke";

        // then
        assertTrue(a == b);
        assertTrue(a == b.intern());
        assertTrue(a.intern() == b);
        assertTrue(a.intern() == b.intern());
    }

    @Test
    void intern_internalizes_string()
    {
        // given
        String a = "01";
        String b = ""; // the value is calculated

        for (int i = 0; i < 2; i++)
        {
            b += i;
        }

        // then
        assertFalse(a == b);
        assertTrue(a == b.intern());
    }

    @Test
    void test3()
    {
        // given
        String a = "William";
        String b = "William";

        // then
        assertTrue(a == b.intern());
        assertTrue(a.intern() == b);
        assertTrue(a.intern() == b.intern());
    }

    @Test
    void exercise_reverse_engineering_designtime_calculated_values_are_not_in_the_string_pool()
    {
        // given
        String a = "John";
        String b = "John";
        String c = "Jo" + "h" + "n";

        String d = ""; // value is calculated
        for (int i = 0; i <= 2; i++)
        {
            d += i;
        }

        // then
        assertTrue(a == b);
        assertTrue(c == a);
        assertTrue(c == b);

        assertFalse(d == a);
        assertFalse(d == b);
        assertFalse(d == c);
    }
}
