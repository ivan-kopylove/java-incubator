package heap.a67b;

import org.junit.jupiter.api.Test;

/// facets:
/// - koan
/// - exercise
class WhyAlwaysFiveExerciseTest
{
    int i = 0;

    @Test
    void recurred()
    {
        i++;
        if (i < 5)
        {
            recurred();
        }
        System.out.println(i);
    }
}
