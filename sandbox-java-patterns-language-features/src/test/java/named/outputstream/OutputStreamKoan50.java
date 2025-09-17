package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class OutputStreamKoan50
{
    @Test
    void what_is_the_purpose_of_the_example() throws IOException
    {
        BufferedOutputStream output = new BufferedOutputStream(System.out, 20);

        // how this possible I can assign chars to byte array?
        // can I assign an emoji?
        // can I assign \n and why?
        output.write(new byte[]{'a', 'b'});
//        output.write(new byte[]{'\uD83D' ); // aka 📙
        output.flush();
    }
}
