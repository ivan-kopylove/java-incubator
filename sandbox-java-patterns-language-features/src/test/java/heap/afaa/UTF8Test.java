package heap.afaa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UTF8Test
{
    @Test
    void test()
    {
        String umlaut = "Ä";
        assertEquals(umlaut, "Ä");
        assertEquals(umlaut, "\u00c4");
    }
}
