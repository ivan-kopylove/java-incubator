package heap.afaa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringTest
{
    @Test
    void exercise_design_reverse_engineering()
    {
        String s = "0123456789_A";

        assertEquals("0123", s.substring(0, 4));
        assertEquals("456789", s.substring(4, 10));
        assertEquals("1" + null, "1null");
    }

    @Test
    void testException()
    {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {

            String s = "0123456789_A";
            int endIndex = "qwee".lastIndexOf("_________"); // what will it return?
            s.substring(0, endIndex); // what will happen here?
        });
    }

    @Test
    void lastIndexOf1()
    {
        int lastIndex = "abcdab".lastIndexOf("a");
        assertEquals(4, lastIndex);
    }

    @Test
    void lastIndexOf11()
    {
        int lastIndex = "abcdab".lastIndexOf("a");
        assertEquals(4, lastIndex);
    }

    @Test
    void lastIndexOf2()
    {
        int lastIndex = "abcdab".lastIndexOf("a", 2);
        assertEquals(0, lastIndex);
    }
}