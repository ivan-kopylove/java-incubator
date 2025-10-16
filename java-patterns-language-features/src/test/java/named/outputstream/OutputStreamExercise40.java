package named.outputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;

class OutputStreamExercise40
{
    @Test
    void exercise_design_reverse_engineering() throws IOException
    {
        //given
        byte[] chars = new byte[3];

        BufferedOutputStream output = new BufferedOutputStream(System.out, chars.length + 1);

        chars[0] = 'c';
        chars[1] = 'd';

        // when
        output.write(chars);
        output.flush();

        chars[1] = 'e';

        // then
        output.write(chars);
        output.flush();
    }
}

