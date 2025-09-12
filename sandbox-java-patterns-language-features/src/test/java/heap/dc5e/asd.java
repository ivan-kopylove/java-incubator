package heap.dc5e;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class asd
{
    @Test
    void what_will_be_printed()
    {
        // then
        IntStream.range(1, 4)
                 .peek(System.out::println)
                 .anyMatch(i -> i > 1);
    }
}
