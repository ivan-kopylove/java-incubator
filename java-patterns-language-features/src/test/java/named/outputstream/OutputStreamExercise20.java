package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what do the 2 examples demonstrate?
public class OutputStreamExercise20
{
    @Test
    void exercise_design_reverse_engineering_1() throws IOException
    {
        byte[] chars = new byte[3];

        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length + 1); // why plus one?

        chars[0] = '(';
        chars[1] = '(';

        output.write(chars);
    }

    @Test
    void exercise_design_reverse_engineering_2() throws IOException
    {
        byte[] chars = new byte[3];
        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length - 1); // why minus one?

        chars[0] = '(';
        chars[1] = '(';

        output.write(chars);
    }
}

