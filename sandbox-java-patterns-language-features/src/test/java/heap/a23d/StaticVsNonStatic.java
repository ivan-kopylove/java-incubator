package heap.a23d;

import org.junit.jupiter.api.Test;

class StaticVsNonStatic
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
        System.out.println("Static");
    }

    {
        System.out.println("Non-static block");
    }
}
