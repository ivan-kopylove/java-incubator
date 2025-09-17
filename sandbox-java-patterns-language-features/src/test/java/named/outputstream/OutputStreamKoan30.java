package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class OutputStreamKoan30
{
    @Test
    void what_will_be_printed() throws IOException
    {
        //given
        byte[] chars = new byte[4];

        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length + 1);

        chars[0] = 'c';
        chars[1] = 'd';

        // when
        output.write(chars);
        output.flush();

        chars[1] = 'e';

        // then
        output.write(chars);
        output.flush();
    }
}

