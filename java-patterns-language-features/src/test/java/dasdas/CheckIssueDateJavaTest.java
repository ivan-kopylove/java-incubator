package dasdas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import heap.qweqweweqweq.TestBase;
class CheckIssueDateJavaTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        // given
        CheckIssueDateJava checkIssueDateJava = new CheckIssueDateJava(LocalDate.of(2004, 03, 15));

        LocalDate dob = LocalDate.of(1990, 03, 15);
        LocalDate issue = dob.plusYears(14);

        // when
        boolean valid = checkIssueDateJava.isValid(dob, issue);

        // then
        assertThat(valid, equalTo(true));
    }

    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        LocalDate dob = LocalDate.of(1990, 03, 15);
        LocalDate current = LocalDate.of(2004, 03, 15);
        LocalDate issue = dob.plusYears(14);

        CheckIssueDateJava checkIssueDateJava = new CheckIssueDateJava(current);

        // when
        boolean valid = checkIssueDateJava.isValid(dob, issue);

        // then
        assertThat(valid, equalTo(true));
    }

    @Test
    void exercise_design_reverse_engineering2()
    {
        // given
        LocalDate dob = LocalDate.of(1990, 03, 15);
        LocalDate current = dob.plusYears(20).plusDays(90);
        LocalDate issue = dob.plusYears(14);

        CheckIssueDateJava checkIssueDateJava = new CheckIssueDateJava(current);

        // when
        boolean valid = checkIssueDateJava.isValid(dob, issue);

        // then
        assertThat(valid, equalTo(true));
    }

    @Test
    void exercise_design_reverse_engineering3()
    {
        // given
        LocalDate dob = LocalDate.of(1990, 03, 15);
        LocalDate current = dob.plusYears(20).plusDays(91);
        LocalDate issue = dob.plusYears(14);

        CheckIssueDateJava checkIssueDateJava = new CheckIssueDateJava(current);

        // when
        boolean valid = checkIssueDateJava.isValid(dob, issue);

        // then
        assertThat(valid, equalTo(false));
    }

    @Test
    void exercise_design_reverse_engineering4()
    {
        // given
        LocalDate dob = LocalDate.of(1990, 03, 15);
        LocalDate current = dob.plusYears(20).plusDays(91);

        LocalDate issue = dob.plusYears(13);

        CheckIssueDateJava checkIssueDateJava = new CheckIssueDateJava(current);

        // when
        boolean valid = checkIssueDateJava.isValid(dob, issue);

        // then
        assertThat(valid, equalTo(false));
    }

    @ParameterizedTest
    @MethodSource("dataSet")
    void exercise_design_reverse_engineering5(LocalDate dob, LocalDate issue, LocalDate current)
    {
        // given
        CheckIssueDateJava checkIssueDateJava = new CheckIssueDateJava(current);

        // when
        boolean valid = checkIssueDateJava.isValid(dob, issue);

        // then
        assertThat(valid, equalTo(false));
    }

    private static List<Arguments> dataSet()
    {
        Supplier<Arguments> case1 = () -> {
            LocalDate dob = LocalDate.of(1990, 03, 15);
            LocalDate currnt = LocalDate.of(2003, 03, 15);
            LocalDate issue = dob.plusYears(20).plusDays(91);

            return arguments(dob, currnt, issue);
        };

        // @formatter:off
        return List.of(case1.get());
        // @formatter:on
    }
}