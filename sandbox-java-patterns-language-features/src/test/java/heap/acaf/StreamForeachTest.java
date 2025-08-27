package heap.acaf;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * java streams playground
 */
class StreamForeachTest
{
    @Test
    void main()
    {
        Random random = new Random();
        random.ints()
              .limit(10)
              .forEach(System.out::println);
    }
}
