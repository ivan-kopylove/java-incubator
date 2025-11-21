package com.att.training.demo.mutations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class CalculatorTest
{
    private Calculator sut;

    @BeforeEach
    void setUp()
    {
        sut = new Calculator();
    }

    @Test
    void add_returnSum()
    {
        int result = sut.add(2, 3);
        assertThat(result, equalTo(5));
    }

    @ParameterizedTest(name = "{index}: abs({0}) = {1}")
    @CsvSource(textBlock = """
            7, 7
            0, 0
            -7, 7
            """
    )
    void givenX_absReturnsY(int input, int expected)
    {
        int actual = sut.abs(input);
        assertThat(actual, equalTo(expected));
    }

    @Test
    void incrementAddsOne()
    {
        int result = sut.increment(10);
        assertThat(result, equalTo(11));
    }

    @Test
    void decrementSubtractsOne()
    {
        int result = sut.decrement(10);
        assertThat(result, equalTo(9));
    }
}
