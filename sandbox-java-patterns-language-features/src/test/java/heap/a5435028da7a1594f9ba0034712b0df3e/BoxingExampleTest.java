package heap.a5435028da7a1594f9ba0034712b0df3e;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@SuppressWarnings("ALL")
class BoxingExampleTest
{
    @Test
    void what_happens_here()
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
