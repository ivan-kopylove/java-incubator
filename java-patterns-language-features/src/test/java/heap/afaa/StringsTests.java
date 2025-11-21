package heap.afaa;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringsTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {

        Stream.of(new MyObj("a"), new MyObj("b"))
              .peek(o -> {
                  if (true)
                  {
                      o.setDasjlkdas("");
                  }
              })
              .collect(Collectors.toList());


        Stream.of(new MyObj("a"), new MyObj("b"))
              .filter(obj -> {
                  return true;
              })
              .collect(Collectors.toList());
    }
}
