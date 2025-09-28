package heap.acaf;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.ivan.kopylove.commons.testing.TestBase;

class OrderOfOperationsMattersTest extends TestBase
{
    @Test
    public  void exercise_design_reverse_engineering1()
    {
        List<String> result1 = Stream.of("1", "22", "333")
                                     .map(s -> s + "-postfix")
                                     .filter(s -> s.length() > 1)
                                     .collect(Collectors.toList());


        assertEquals(3, result1.size());
    }

    @Test
    public  void exercise_design_reverse_engineering2()
    {
        List<String> result2 = Stream.of("1", "22", "333")
                                     .filter(s -> s.length() > 1)
                                     .map(s -> s + "-postfix")
                                     .collect(Collectors.toList());

        assertEquals(2, result2.size());
    }
}
