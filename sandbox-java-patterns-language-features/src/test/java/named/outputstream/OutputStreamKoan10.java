package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class OutputStreamKoan10
{
    @Test
    void example_1()
    {
        // given
        char[] chars = new char[4];

        // when
        chars[0] = 'a';
        chars[1] = 'b';
        // what is implicit here?

        // then
        System.out.println(chars);
    }
}
