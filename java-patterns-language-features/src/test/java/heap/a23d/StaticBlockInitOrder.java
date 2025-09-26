package heap.a23d;

import org.junit.jupiter.api.Test;

class StaticBlockInitOrder
{
    @Test
    void reverse_engineer_hypothetical_design_of_the_example()
    {
        Parent p = new Child();
    }
}

class Parent
{
    static
    {
        System.out.println("Parent static block initialized first.");
    }
}

class Child extends Parent
{
    static
    {
        System.out.println("Child static block initialized second.");
    }
}