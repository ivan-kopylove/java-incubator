package heap.ac56;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodHidingOnStaticClassMethodsTest
{
    @Test
    void reverse_engineer_hypothetical_design_of_the_example()
    {
        Child1 child = new Child1();

        assertEquals("child", Child1.getValue());
        assertEquals("parent", Child2.getValue());
        assertEquals("parent", Parent.getValue());
    }
}
