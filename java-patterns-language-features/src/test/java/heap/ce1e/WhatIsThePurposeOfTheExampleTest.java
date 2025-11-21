package heap.ce1e;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class WhatIsThePurposeOfTheExampleTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);

        list2.add(1);
        list2.add(2);

        //        System.out.println(list1.equals(list2));
    }

    @Test
    void exercise_design_reverse_engineering2()
    {
        // given
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);

        list2.add(2);
        list2.add(1);

        //        System.out.println(list1.equals(list2));
    }
}
