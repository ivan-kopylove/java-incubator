package heap.af51;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BoxingExampleTest
{
    @Test
    void reverse_engineer_hypothetical_design()
    {
        Character ch = 'a';
    }

    @Nested
    class TrickyCases
    {

        @Test
        void reverse_engineer_hypothetical_design_01()
        {
            // given
            Integer a = 127;
            Integer b = 127;

            // then
            System.out.println("a == b: " + (a == b));
        }

        @Test
        void reverse_engineer_hypothetical_design_and_why()
        {
            // given
            Integer a = 128;
            Integer b = 128;

            // then
            System.out.println("a == b: " + (a == b));
        }

        @Test
        void reverse_engineer_hypothetical_design_and_why_02()
        {
            // given
            Integer a = new Integer(127);
            Integer b = new Integer(127);

            // then
            System.out.println("a == b: " + (a == b));
        }
    }
}
