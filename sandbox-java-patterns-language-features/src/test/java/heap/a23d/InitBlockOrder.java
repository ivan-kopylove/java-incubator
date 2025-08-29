package heap.a23d;

import org.junit.jupiter.api.Test;

class InitBlockOrder
{
    @Test
    void foo()
    {
        A a = new B();
    }
}

class A
{

    //    The non-static block:
    {
        System.out.println("Parent non-static block initialized first.");
    }
}

class B extends A
{
    //    The non-static block:
    {
        System.out.println("Child non-static block initialized second.");
    }
}