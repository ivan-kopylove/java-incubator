package leetcode.L2571;

import org.junit.jupiter.api.Test;

class ee94
{
    /// - what will be printed?
    /// - what kind of number 32 is?
    /// - what if there were another number?
    /// - what does `&` operator do?
    @Test
    void exercise_design_reverse_engineering()
    {
        // given
        int n = 32;

        // when
        boolean result = (n & (n - 1)) == 0;

        // then
        System.out.println(result);
    }
}
