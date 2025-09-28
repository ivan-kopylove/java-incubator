package heap.afaa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import heap.qweqweweqweq.TestBase;
class StringFormatTest extends TestBase
{
    @Test
    void main()
    {
        String s = "\u221E \u0020sometext";
        System.out.println(s);
        assertEquals("∞  sometext", s);
    }
}
