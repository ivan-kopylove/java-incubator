package heap.a965;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ATest
{

    @Test
    @DisplayName("what is the purpose of this example?")
    void what_is_the_purpose_of_this_example() throws InterruptedException
    {
        // given
        MyHouse myHouse = new MyHouse();

        // when

        myHouse.eatPizza();
        myHouse.pizzaGuy();

        // then
        MatcherAssert.assertThat("actual result", CoreMatchers.equalTo("expected result"));
    }
}
