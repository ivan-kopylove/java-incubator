package heap.a21b;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FinalVariableInsideCallbackTestTest
{
    @Test
    void main()
    {
        assertNotEquals(null, new Foo());
        assertNotEquals(null, new Date());
    }
}
