import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what do these 2 examples demonstrate?
public class ewqweq
{

    @Test
    void example_1() throws IOException
    {
        BufferedOutputStream output = new BufferedOutputStream(System.out, 6); // why exactly 6?

        byte[] abc = new byte[5];
        abc[0] = '(';
        abc[1] = '(';

        output.write(abc);
    }

    @Test
    void example_2() throws IOException
    {
        BufferedOutputStream output = new BufferedOutputStream(System.out, 1);

        byte[] abc = new byte[5];
        abc[0] = '(';
        abc[1] = '(';

        output.write(abc);
    }
}

