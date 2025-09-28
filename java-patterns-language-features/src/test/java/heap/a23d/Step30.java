package heap.a23d;

import org.junit.jupiter.api.Test;

class Step30
{

    @Test
    void main()
    {
        new MyClass();
        new MyClass();
    }
}

class MyClass
{

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }
}
