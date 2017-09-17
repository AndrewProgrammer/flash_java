package com.hillel.FibonacciSequence;

public class FibonacciSequence {

    public int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public int fibonacci2(int n) {

        int first = 1;
        int second = 1;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}
