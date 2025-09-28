package named.concurrencyWaitNotify02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import heap.qweqweweqweq.TestBase;
class PizzaNotifierTest extends TestBase
{
    @Test
    @DisplayName("what is the purpose of this example?")
    void what_is_the_purpose_of_this_example() throws InterruptedException
    {
        // given
        MyHouse myHouse = new MyHouse();

        // when
        new Thread(() -> {myHouse.eatPizza();}).start();
        Thread.sleep(2_000);

        assertDoesNotThrow(() -> {
            myHouse.pizzaGuy();
        });
    }
}
