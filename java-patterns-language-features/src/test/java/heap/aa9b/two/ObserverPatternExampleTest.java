package heap.aa9b.two;

import org.junit.jupiter.api.Test;

/// [...](https://stackoverflow.com/questions/6270132/create-a-custom-event-in-java)
/// facets:
/// - listener
/// - patterns
class ObserverPatternExampleTest
{
    @Test
    void reverse_engineer_hypothetical_design()
    {
        Initiater initiater = new Initiater();
        Responder responder = new Responder();

        initiater.addListener(responder);

        initiater.sayHello();  // Prints "Hello!!!" and "Hello there..."
    }
}