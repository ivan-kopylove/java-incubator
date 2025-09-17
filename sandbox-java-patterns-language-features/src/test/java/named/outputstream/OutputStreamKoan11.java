package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what do the 2 examples demonstrate?
public class OutputStreamKoan11
{
    @Test
    void what_will_be_printed_1() throws IOException
    {
        byte[] chars = new byte[4];

        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length + 1); // why plus one?

        chars[0] = '(';
        chars[1] = '(';

        output.write(chars);
    }

    @Test
    void what_will_be_printed_2() throws IOException
    {
        byte[] chars = new byte[4];
        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length - 1); // why minus one?

        chars[0] = '(';
        chars[1] = '(';

        output.write(chars);
    }
}

