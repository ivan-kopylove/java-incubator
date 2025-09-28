package heap.a21b;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EqualsHashcodeNotCalled
{
    private boolean equalsCalled   = false;
    private boolean hashcodeCalled = false;

    @Test
    void exercise_reverse_engineering_design()
    {
        new MyClass();
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        assertNotSame(myClass1, myClass2);
        assertFalse(equalsCalled);
        assertFalse(hashcodeCalled);
    }

    @Test
    void exercise_reverse_engineering_design2()
    {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        myClass1.equals(myClass2);


        assertTrue(equalsCalled);
        assertFalse(hashcodeCalled);
    }

    @Test
    void exercise_reverse_engineering_design3()
    {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        Set<MyClass> set = new HashSet<>();
        set.add(myClass1);
        set.add(myClass2);

        assertFalse(equalsCalled);
        assertTrue(hashcodeCalled);
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
