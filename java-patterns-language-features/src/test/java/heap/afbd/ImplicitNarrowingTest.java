package heap.afbd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImplicitNarrowingTest
{

    @Test
    void reverse_engineer_hypothetical_design1()
    {
        int i1 = 100;
        byte b1 = (byte) i1;
        System.out.println(b1);
        assertEquals(100, b1);
    }

    @Test
    void reverse_engineer_hypothetical_design2()
    {
        int i1 = 127;
        byte b1 = (byte) i1;
        assertEquals(127, b1);
    }

    @Test
    void reverse_engineer_hypothetical_design3()
    {
        int i1 = 128;
        byte b1 = (byte) i1;
        assertEquals(-128, b1);
    }

    @Test
    void reverse_engineer_hypothetical_design4()
    {
        int i1 = 255;
        byte b1 = (byte) i1;
        assertEquals(-1, b1);
    }
}
