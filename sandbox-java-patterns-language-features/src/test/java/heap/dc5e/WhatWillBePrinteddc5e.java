package heap.dc5e;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class WhatWillBePrinteddc5e
{
    @Test
    void what_will_be_printed_and_why()
    {
        // then
        IntStream.range(1, 4)
                 .peek(System.out::println)
                 .anyMatch(i -> i > 1);
    }
}
