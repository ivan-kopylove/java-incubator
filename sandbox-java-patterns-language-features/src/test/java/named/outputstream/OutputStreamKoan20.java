package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what do these 2 examples demonstrate?
/// what will each example print?
public class OutputStreamKoan20
{
    @Test
    void what_will_be_printed_1() throws IOException
    {
        byte[] abc = new byte[5];
        BufferedOutputStream output = new BufferedOutputStream(System.out, abc.length + 1); // why exactly +1?

        abc[0] = 'a';
        abc[1] = 'b';

        output.write(abc);
    }

    @Test
    void what_will_be_printed_2() throws IOException
    {
        byte[] abc = new byte[5];
        BufferedOutputStream output = new BufferedOutputStream(System.out, abc.length + 1);

        abc[0] = 'c';
        abc[1] = 'd';

        output.write(abc);
        output.flush();
    }


}

