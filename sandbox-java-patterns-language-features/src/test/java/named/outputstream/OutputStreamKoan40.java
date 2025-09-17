package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what does the example demonstrate?
public class OutputStreamKoan40
{
    @Test
    void what_will_be_printed() throws IOException
    {
        // given
        byte[] chars = new byte[4];

        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length + 1);

        chars[0] = 'c';
        chars[1] = 'd';
        chars[chars.length - 1] = '\n'; // in what situation this approach might be useful?

        // then
        output.write(chars);
        output.flush();

        chars[1] = 'e';

        output.write(chars);
        output.flush();
    }
}

