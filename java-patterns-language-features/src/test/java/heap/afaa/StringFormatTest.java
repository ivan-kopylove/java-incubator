package heap.afaa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.ivan.kopylove.commons.testing.TestBase;
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
