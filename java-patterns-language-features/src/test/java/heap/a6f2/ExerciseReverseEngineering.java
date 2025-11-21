package heap.a6f2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ExerciseReverseEngineering
{
    @Test
    void exercise_design_reverse_engineering2()
    {
        // given
        int[] a = new int[]{1, 2};

        // then
        Map<int[], String> map = new HashMap<>();
        map.put(a, "something");

        System.out.println(map.get(a));
        System.out.println(map.get(new int[]{1, 2}));
    }

    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        int[] a = new int[]{1, 2};
        int[] b = new int[]{1, 2};

        // then
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
    }
}
