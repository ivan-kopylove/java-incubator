package heap.adde;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// java.mechanics.oop.hiding
import com.github.ivan.kopylove.commons.testing.TestBase;
class ClassHidesVariableTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        String localVariable = new ClassHidesVariable().getLocalVariable();

        assertEquals("instance variable", new ClassHidesVariable().getInstanceVariableWithThis());
        assertEquals("instance variable", new ClassHidesVariable().getInstanceVariable());
        assertEquals("method local variable", new ClassHidesVariable().getLocalVariable());
    }

    class ClassHidesVariable
    {
        private final String message = "instance variable";

        String getLocalVariable()
        {
            String message = "method local variable";
            return message;
        }

        String getInstanceVariableWithThis()
        {
            String message = "method local variable";
            return this.message;
        }

        String getInstanceVariable()
        {
            return message;
        }
    }
}
