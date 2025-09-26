package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what does the example demonstrate?
public class OutputStreamKoan50
{
    @Test
    void reverse_engineer_hypothetical_design() throws IOException
    {
        // given
        byte[] chars = new byte[3];

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

