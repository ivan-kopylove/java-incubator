package heap.aa9b.two;

import org.junit.jupiter.api.Test;


import com.github.ivan.kopylove.commons.testing.TestBase;
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