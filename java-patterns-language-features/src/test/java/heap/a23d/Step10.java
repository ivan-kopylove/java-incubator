package heap.a23d;

import org.junit.jupiter.api.Test;

class Step10
{
    @Test
    void exercise_design_reverse_engineering()
    {
        Parent p = new Child();
    }
}

class Parent
{
    static
    {
        System.out.println("1");
    }
}

class Child extends Parent
{
    static
    {
        System.out.println("2");
    }
}