package heap.afaa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.ivan.kopylove.commons.testing.TestBase;
class UTF8Test extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        String umlaut = "Ä";
        assertEquals(umlaut, "Ä");
        assertEquals(umlaut, "\u00c4");
    }
}
