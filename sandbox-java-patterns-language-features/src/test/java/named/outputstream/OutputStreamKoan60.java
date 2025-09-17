package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class OutputStreamKoan60
{
    @Test
    void what_is_the_purpose_of_the_example() throws IOException
    {
        BufferedOutputStream output = new BufferedOutputStream(System.out, 20);

        output.write(new byte[]{'a', 'b'}); // how this possible I can assign chars to byte array?
//        output.write(new byte[]{128 }); // can I assign 128?
//        output.write(new byte[]{'\n' }); // can I assign \n and why?
//        output.write(new byte[]{'\uD83D' ); // can I assign an emoji? aka 📙
        output.flush();
    }
}
