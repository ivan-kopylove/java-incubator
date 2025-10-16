package heap.cd3c;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class dasdas
{
    @Test
    void exercise_design_reverse_engineering()
    {
        // given
        IntStream chars = "abc".chars(); // why .chars() returns IntStream? what's the difference between IntStream and Stream<?>?
        // how can I convert this stream to charcaters?

        // then
        chars.forEach(System.out::println);
    }
}
