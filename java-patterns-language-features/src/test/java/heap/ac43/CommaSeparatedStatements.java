package heap.ac43;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommaSeparatedStatements
{
    @Test
    void validSyntax()
    {
        float foo = 2, bar = 3, baz = 4;//1//
        float mod1 = foo % baz, mod2 = baz % foo;  //2
        float result = mod1 > mod2 ? bar : baz; //3
        //        assertEquals(, myResultField); //calculate yourself
    }

    @Test
    void what_will_be_printed()
    {
        int a = 1;
        int b = 2;
        int c = 3;

        int d = a + (b = c);
        System.out.println(d);
    }

    @Test
    void exercise_reverse_engineering_design1()
    {
        int a = 'c' | 'd';
        int b = 99 | 100;
        char c = 99 | 100;

        System.out.println(a == b);
        System.out.println(a == c);
    }

    @Test
    void exercise_reverse_engineering_design2()
    {
        char[] ca = {'a', 'b', 'c', 'd'};

        int i = 0;

        for (char c : ca)
        {
            switch (c)
            {
                case 'a':
                    i++;
                case 'b':
                    ++i;
                case 'c' | 'd': // a follow-up: what letter do I need to add to the array above to match this first?
                    i++;
            }
        }
        assertEquals(5, i);
    }
}
