import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what do these 2 examples demonstrate?
/// what will each example print?
public class ewqweq2
{

    @Test
    void example_1() throws IOException
    {
        BufferedOutputStream output = new BufferedOutputStream(System.out, 6); // why exactly 6?

        byte[] abc = new byte[5];
        abc[0] = 'a';
        abc[1] = 'b';

        output.write(abc);
    }

      @Test
    void example_2() throws IOException
    {
        BufferedOutputStream output = new BufferedOutputStream(System.out, 6); // why exactly 6?

        byte[] abc = new byte[5];
        abc[0] = 'c';
        abc[1] = 'd';

        output.write(abc);
        output.flush();
    }


}

