package heap.aedc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.KOAN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class MapEqualityTest
{
    @Test
    void what_will_be_printed_1()
    {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 3);
        map1.put(2, 4);

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 3);
        map2.put(2, 4);


        if (EDUCATION_MODE == KOAN)
        {
            fail("try to predict yourself before running the assertion");
        }
        System.out.println(map1.equals(map2)); // how can I get an evidence prooving or falsifying this (without running)?
        assertEquals(map1, map2);
    }

    @Test
    void what_will_be_printed_2()
    {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        map1.put(1, List.of(1, 2));
        map1.put(2, List.of(4, 5));

        Map<Integer, List<Integer>> map2 = new HashMap<>();
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();

        list1.add(1);
        list1.add(2);

        list2.add(4);
        list2.add(5);

        map2.put(1, list1);
        map2.put(2, list2);

        if (EDUCATION_MODE == KOAN)
        {
            fail("try to predict yourself before running the assertion");
        }
        System.out.println(map1.equals(map2)); // how can I get an evidence prooving or falsifying this (without running)?
        assertEquals(map1, map2);
    }
}
