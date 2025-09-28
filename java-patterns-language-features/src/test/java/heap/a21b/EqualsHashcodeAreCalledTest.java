package heap.a21b;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import heap.qweqweweqweq.TestBase;
class EqualsHashcodeAreCalledTest extends TestBase
{
    private boolean equalsCalled   = false;
    private boolean hashcodeCalled = false;

    @Test
    void exercise_design_reverse_engineering2()
    {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        myClass1.equals(myClass2);

        assertTrue(equalsCalled);
        assertFalse(hashcodeCalled);
    }

    class MyClass
    {
        @Override
        public boolean equals(Object o)
        {
            equalsCalled = true;
            return super.equals(o);
        }

        @Override
        public int hashCode()
        {
            hashcodeCalled = true;
            return super.hashCode();
        }
    }
}
