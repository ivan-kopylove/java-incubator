package heap.ce1e;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WhatIsThePurposeOfTheExampleTest
{
    @Test
    void exercise_reverse_engineering_design1()
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
    void exercise_reverse_engineering_design2()
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
