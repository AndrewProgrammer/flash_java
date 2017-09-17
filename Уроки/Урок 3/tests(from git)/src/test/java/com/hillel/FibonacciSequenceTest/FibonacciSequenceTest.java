package com.hillel.FibonacciSequenceTest;

import com.hillel.FibonacciSequence.FibonacciSequence;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciSequenceTest {

    @Test
    public void shouldReturn8For6thElement() {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        int result = fibonacciSequence.fibonacci(6);

        assertEquals(" Didn`t return correct result for 6th element", 8, result );

    }

}
