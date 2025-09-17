import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what do these 2 examples demonstrate?
public class OutputStreamKoan11
{
    @Test
    void what_will_be_printed_1() throws IOException
    {
        byte[] abc = new byte[5];

        BufferedOutputStream output = new BufferedOutputStream(System.out, abc.length + 1); // why plus one?

        abc[0] = '(';
        abc[1] = '(';

        output.write(abc);
    }

    @Test
    void what_will_be_printed_2() throws IOException
    {
        byte[] abc = new byte[5];
        BufferedOutputStream output = new BufferedOutputStream(System.out, abc.length - 1); // why minus one?

        abc[0] = '(';
        abc[1] = '(';

        output.write(abc);
    }
}

