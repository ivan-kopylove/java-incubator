package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class OutputStreamKoan50
{
    /// [1](https://google.com/search?q="наденем+буфер+в+64+килобайта%2C+он+не+имеет+своего+буфера")
    @Test
    void example_2() throws IOException
    {
        BufferedOutputStream output = new BufferedOutputStream(System.out, 20); // why plus one?

        output.write(new byte[]{'a', 'b'});
        output.flush();
    }
}
