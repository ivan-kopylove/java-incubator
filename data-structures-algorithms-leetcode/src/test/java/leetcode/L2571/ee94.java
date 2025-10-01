package leetcode.L2571;

import org.junit.jupiter.api.Test;

class ee94
{
    /// - what will be printed?
    /// - what kind of number 32 is?
    /// - what if there were another number?
    /// - what does `&` operator do?
    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        int n = 32;

        // when
        boolean result = (n & (n - 1)) == 0;

        // then
        System.out.println(result);
    }

    @Test
    void pronounce_property_names_out_of_loud()
    {
        // then
        System.out.println(5 ^ 5);
        System.out.println(5 ^ 0);
        System.out.println(0 ^ 5);
        System.out.println(((4 ^ 5) ^ 6) == ((6 ^ 5) ^ 4));
    }
}
