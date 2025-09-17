package heap.acaf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupingByBasicExampleTest
{
    @Test
    void foo1()
    {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);

        Map<Boolean, List<Integer>> collect = ints.stream().collect(Collectors.groupingBy(integer -> integer > 1));

        assertEquals(3, (int) collect.get(true).get(1));
    }

    @Test
    void foo2()
    {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(3);

        Map<Integer, List<Integer>> groupedBy = ints.stream().collect(Collectors.groupingBy(integer -> integer));

        assertEquals(3, (int) groupedBy.get(true).get(1));
    }


}
