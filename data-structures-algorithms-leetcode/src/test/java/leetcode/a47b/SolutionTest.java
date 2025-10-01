package leetcode.a47b;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Disabled
class SolutionTest extends TestBase
{
    private static InputStream originalSystemIn;

    @BeforeAll
    public static void init()
    {
        originalSystemIn = System.in;
    }

    @AfterAll
    public static void destroy()
    {
        System.setIn(originalSystemIn);
    }

    /// why cannot I just extract into a separate func and test it separately from input reading?
    @Test
    void what_is_the_purpose_of_this_test() throws Exception
    {
        // given
        String input = "ab\nba\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());

        System.setIn(bais);

        // when
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);

        System.setOut(printStream);

        MySolution_168_testsPassed_MemoryLimit.main(new String[]{});
        String string = baos.toString();

        // then


        assertThat(string, equalTo("expected result"));
    }
}
