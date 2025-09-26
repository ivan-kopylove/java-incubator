package heap.afaa;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringsTests
{
    @Test
    void reverse_engineer_hypothetical_design_of_the_example()
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
