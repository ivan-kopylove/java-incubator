package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class OutputStreamKoan10
{
    @Test
    void example_1()
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

    /// [1](https://google.com/search?q="наденем+буфер+в+64+килобайта%2C+он+не+имеет+своего+буфера")
    @Test
    void example_2() throws IOException
    {
        BufferedOutputStream output = new BufferedOutputStream(System.out, 20); // why plus one?

        output.write(new byte[] { 'a', 'b' });
        output.flush();
    }
}
