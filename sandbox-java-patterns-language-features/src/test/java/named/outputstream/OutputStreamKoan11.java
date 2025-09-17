package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

public class OutputStreamKoan11
{
    /// [1](https://www.google.com/search?q=%22%D0%9D%D0%B0+System.out+%D0%BD%D0%B0%D0%B4%D0%B5%D0%BD%D0%B5%D0%BC+%D0%B1%D1%83%D1%84%D0%B5%D1%80+%D0%B2+64+%D0%BA%D0%B8%D0%BB%D0%BE%D0%B1%D0%B0%D0%B9%D1%82%D0%B0%2C+%D0%BE%D0%BD+%D0%BD%D0%B5+%D0%B8%D0%BC%D0%B5%D0%B5%D1%82+%D1%81%D0%B2%D0%BE%D0%B5%D0%B3%D0%BE+%D0%B1%D1%83%D1%84%D0%B5%D1%80%D0%B0.%22)
    @Test
    void what_is_the_purpose_of_the_example() throws IOException
    {
        // does System.out has it's own buffer?
        // what if there is no buffer - what happens each println() without buffer?
        BufferedOutputStream output = new BufferedOutputStream(System.out, 20);

        output.write(new byte[]{'a', 'b'});
        output.flush();
    }
}
