package com.java.dynamicProgramming;

public class FibonacciSeries {
    static int fib(int n)
    {
        int f[] = new int[n + 2]; // 1 extra to handle case, n = 0
        int i;
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
// 1 1 2 3 5 8 13 21 34
    public static void main(String args[])
    {
        int n = 9;
        System.out.println(fib(n));
    }
}