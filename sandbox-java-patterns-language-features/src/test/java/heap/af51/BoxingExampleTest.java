package heap.af51;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BoxingExampleTest
{
    @Test
    void an_example_of_what()
    {
        Character ch = 'a';
    }

    @Nested
    class TrickyCases
    {

        @Test
        void what_will_be_printed_01()
        {
            // given
            Integer a = 127;
            Integer b = 127;

            // then
            System.out.println("a == b: " + (a == b));
        }

        @Test
        void what_will_be_printed_and_why()
        {
            // given
            Integer a = 128;
            Integer b = 128;

            // then
            System.out.println("a == b: " + (a == b));
        }

        @Test
        void what_will_be_printed_and_why_02()
        {
            // given
            Integer a = new Integer(127);
            Integer b = new Integer(127);

            // then
            System.out.println("a == b: " + (a == b));
        }
    }
}
