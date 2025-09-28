package heap.aa9b.two;

import org.junit.jupiter.api.Test;

/// [...](https://stackoverflow.com/questions/6270132/create-a-custom-event-in-java)

/// - listener

import heap.qweqweweqweq.TestBase;
class ObserverPatternExampleTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        Initiater initiater = new Initiater();
        Responder responder = new Responder();

        initiater.addListener(responder);

        initiater.sayHello();  // Prints "Hello!!!" and "Hello there..."
    }
}