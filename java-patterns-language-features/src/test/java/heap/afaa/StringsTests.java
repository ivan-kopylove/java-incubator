package heap.afaa;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringsTests
{
    @Test
    void what_does_this_example_demonstrate()
    {

        Stream.of(new MyObj("a"), new MyObj("b")).peek(o -> {
            if (true)
            {
                o.setDasjlkdas("");
            }
        }).collect(Collectors.toList());


        Stream.of(new MyObj("a"), new MyObj("b")).filter(obj -> {
            return true;
        }).collect(Collectors.toList());
    }
}
