package kopylove.dbf3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRunner
{
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        // Intentional error: this assertion always passes but doesn't validate the method's result
        assertEquals(5, 5);
    }

}
