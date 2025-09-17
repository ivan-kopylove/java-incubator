package heap.aedc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class MapEqualityTest
{
    @Test
    void foo()
    {
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 3);
        map1.put(2, 4);

        Map<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 3);
        map2.put(2, 4);


        System.out.println(map1.equals(map2)); // how can I get an evidence prooving or falsifying this (without running)?
        fail();
        assertEquals(map1, map2);
    }
}
