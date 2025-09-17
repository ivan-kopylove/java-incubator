package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what do these 2 examples demonstrate?
/// what will each example print?
public class OutputStreamKoan30
{

    @Test
    void what_will_be_printed() throws IOException
    {
        //given
        byte[] abc = new byte[5];

        BufferedOutputStream output = new BufferedOutputStream(System.out, abc.length + 1);

        abc[0] = 'c';
        abc[1] = 'd';

        // when
        output.write(abc);
        output.flush();

        abc[1] = 'e';

        // then
        output.write(abc);
        output.flush();
    }
}

