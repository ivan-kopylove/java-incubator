package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what does this example demonstrate?
/// what will be printed?
public class OutputStreamKoan40
{
    @Test
    void what_will_be_printed() throws IOException
    {
        // given
        byte[] abc = new byte[5];

        BufferedOutputStream output = new BufferedOutputStream(System.out, abc.length + 1);

        abc[0] = 'c';
        abc[1] = 'd';
        abc[abc.length - 1] = '\n';

        // then
        output.write(abc);
        output.flush();

        abc[1] = 'e';

        output.write(abc);
        output.flush();
    }
}

