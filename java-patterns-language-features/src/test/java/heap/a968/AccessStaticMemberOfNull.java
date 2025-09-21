package heap.a968;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessStaticMemberOfNull
{
    @Test
    void try_to_predict_the_result_before_uncommenting()
    {
        MyClass a = new MyClass();
        a = null;

        assertEquals("some value", MyClass.VALUE);
        assertEquals("some value", a.VALUE);
        assertEquals("some text", MyClass.foo());
        assertEquals("some text", a.foo());
    }
}
