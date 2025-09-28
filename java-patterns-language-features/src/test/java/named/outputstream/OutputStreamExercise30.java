package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

/// what do the 2 examples demonstrate?
public class OutputStreamExercise30
{
    @Test
    void exercise_reverse_engineering_design_1() throws IOException
    {
        byte[] chars = new byte[3];
        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length + 1); // why exactly +1?

        chars[0] = 'a';
        chars[1] = 'b';

        output.write(chars);
    }

    @Test
    void exercise_reverse_engineering_design_2() throws IOException
    {
        byte[] chars = new byte[3];
        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length + 1);

        chars[0] = 'c';
        chars[1] = 'd';

        output.write(chars);
        output.flush();
    }
}

