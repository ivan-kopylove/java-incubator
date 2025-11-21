package heap.aedc;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraysEqualityTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");

        assertEquals(list, list2); //compared in AbstractList.equals() one by one
    }
}
