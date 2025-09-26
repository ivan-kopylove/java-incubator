package heap.dc5e;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class WhatWillBePrinteddc5e
{
    // what word describes this effect? (the word is also used in Hibernate, Singletons, method references)?
    @Test
    void reverse_engineer_hypothetical_design_and_why()
    {
        // then
        IntStream.range(1, 4).peek(System.out::println).anyMatch(i -> i > 1);
    }
}
