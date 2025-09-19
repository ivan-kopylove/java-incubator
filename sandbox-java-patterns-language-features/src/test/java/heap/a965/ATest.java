package heap.a965;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class ATest
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
        assertThat("actual result", equalTo("expected result"));
    }
}
