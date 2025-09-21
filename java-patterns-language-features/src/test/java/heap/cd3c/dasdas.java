package heap.cd3c;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class dasdas
{
    @Test
    void what_will_be_printed()
    {
        // given
        IntStream chars = "abc".chars(); // why .chars() returns IntStream? what's the difference between IntStream and Stream<?>?
        // how can I convert this stream to charcaters?

        // then
        chars.forEach(System.out::println);
    }
}
