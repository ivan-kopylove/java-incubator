package heap.a7d5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Predicates
{
    @Test
    void main()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        sumAll(numbers, jkljlkj -> true);
    }

    int sumAll(List<Integer> numbers, Predicate<Integer> p)
    {
        int total = 0;
        for (int number : numbers)
        {
            if (p.test(number))
            {
                total += number;
            }
        }
        return total;
    }
}
