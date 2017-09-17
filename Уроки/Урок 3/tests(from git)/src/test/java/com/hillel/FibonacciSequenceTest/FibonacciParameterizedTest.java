package com.hillel.FibonacciSequenceTest;

import com.hillel.FibonacciSequence.FibonacciSequence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciParameterizedTest {

    private int input;
    private int expecteResult;

    public FibonacciParameterizedTest(int input, int expecteResult){
        this.input = input;
        this.expecteResult = expecteResult;
    }

    @Parameterized.Parameters
    public static List<Object[]> params() {
        return Arrays.asList(new Object[][] {
                {6,8},
                {1,1},
                {3,2},
                {4,3}
        });
    }

    @Test
    public void calcilateFibonacci() {
        FibonacciSequence fibonacciSequence =  new FibonacciSequence();

        int result = fibonacciSequence.fibonacci2(input);

        assertEquals(expecteResult,input);
    }

}
