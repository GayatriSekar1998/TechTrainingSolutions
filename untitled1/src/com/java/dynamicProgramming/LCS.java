package com.java.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LCS {
    public static int LCS(String X, String Y, int i, int j, Map< String, Integer > dp) {
        if (i == 0 || j == 0) {
            return 0;
        }
        String key = i + "|" + j;
        if (!dp.containsKey(key)) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                dp.put(key, LCS(X, Y, i - 1, j - 1, dp) + 1);
            } else
                dp.put(key, Integer.max(LCS(X, Y, i, j - 1, dp),
                        LCS(X, Y, i - 1, j, dp)));
        }
        return dp.get(key);
    }

    public static void main(String[] args) {
        String X = "abc";
        String Y = "adb";
        int m = X.length();
        int n = Y.length();

        // Create a map for memoization
        Map<String, Integer> dp = new HashMap<>();

        // Call the LCS function and print the result
        System.out.println("Length of LCS is " + LCS(X, Y, m, n, dp));
    }
}