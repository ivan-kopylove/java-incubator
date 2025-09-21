package heap.a98b;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArraysAsListFixedSizeExampleTest
{
    @Test
    void Arrays_asList_is_what()
    {
        assertThrows(UnsupportedOperationException.class, () -> {

            List<String> immutableList = Arrays.asList("1", "2");
            immutableList.add("3");
        });
    }

    @Test
    void Collections_singletonList_is_what()
    {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<String> immutableList = Collections.singletonList("a");
            immutableList.add("b");
        });
    }

    @Test
    void what_does_this_demonstrate()
    {
        List<String> immutableList = Arrays.asList("1", "2");
        List<String> mutableList = new ArrayList<>(immutableList);
        mutableList.add("3");
        assertEquals("3", mutableList.get(2));
    }
}
