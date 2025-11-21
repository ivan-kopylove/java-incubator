package heap.asd213123;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class das
{
    @Test
    void exercise_design_reverse_engineering1()
    {
        int a = 0;

        if (a++ == 0)
        {
            System.out.println(a);
        }

        if (++a == 0)
        {
            System.out.println(a);
        }
    }

    @Test
    void exercise_design_reverse_engineering2()
    {
        int[] arr = new int[]{0, 0, 0};
        int a = 0;

        arr[a++] = 5;
        System.out.println(Arrays.toString(arr));

        arr[++a] = 4;
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void exercise_design_reverse_engineering3()
    {
        int a = 0;
        print(a++);
        print(++a);
    }

    void print(int a)
    {
        System.out.println(a);
    }

    @Test
    void exercise_design_reverse_engineering4()
    {
        int a = 5;

        while (true)
        {
            if (true && a-- == 0)
            {
                return;
            }

            System.out.println(a);
        }
    }
}
