package heap.a23d;

import org.junit.jupiter.api.Test;

class Step40
{
    @Test
    void reverse_engineer_hypothetical_design()
    {
        Foo a = new Bar();
    }
}

class Foo
{
    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }
}

class Bar extends Foo
{
    static
    {
        System.out.println("3");
    }

    {
        System.out.println("4");
    }
}