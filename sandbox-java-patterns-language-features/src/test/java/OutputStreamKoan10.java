import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class OutputStreamKoan10
{
    @Test
    void what_will_be_printed()
    {
        // given
        char[] chars = new char[5];

        // when
        chars[0] = 'a';
        chars[1] = 'b';
        // what is implicit here?

        // then
        System.out.println(chars);
    }
}
