package heap.aedc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraysEqualityTest
{
    @Test
    void what_does_this_example_demonstrate()
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
