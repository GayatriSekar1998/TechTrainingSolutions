package com.java.backtracking;

import java.util.*;

class Solution {
    public static List<String> generateParentheses(int n) {
        List<String> validAnswers = new ArrayList<>();
        char[] currentString = new char[2 * n];//
        recurse(n, n, 0, currentString, validAnswers);//recurse(n=2,n=2,0,currentString,validAnswers)

        return validAnswers;
    }
    private static void recurse(int forwardParensNeeded, int backwardsParensNeeded, int currentIndex,
                                char[] currentString, List<String> validAnswers) {
        //forwardParensNeeded = 2, backwardsParensNeeded = 2, currentIndex =0,currentString, validAnswers
      //  recurse(forwardParensNeeded = 1,backwardsParensNeeded=2,currentIndex=1,{'(',0,0,0},{})
        //second call rcurse(0,2,2,{'(','(,0,0},{}))
        //third call recurse(0,1,3,{'(','(,')',0},{});
        if (forwardParensNeeded == 0 && backwardsParensNeeded == 0) {//
            validAnswers.add(new String(currentString));
            return;
        }
        if (forwardParensNeeded > 0) {//0>0
            currentString[currentIndex] = '(';
            recurse(forwardParensNeeded - 1, backwardsParensNeeded, currentIndex + 1,
                    currentString, validAnswers);// first call recurse(1,2,1,{'(',0,0,0},{}) ----- second call rcurse(0,2,2,{'(','(,0,0},{}))
        }
        if (backwardsParensNeeded > 0 && forwardParensNeeded < backwardsParensNeeded) {//1>0 && 0<1
            currentString[currentIndex] = ')';
            recurse(forwardParensNeeded, backwardsParensNeeded - 1, currentIndex + 1,
                    currentString, validAnswers);// third call recurse(0,1,3,{'(','(,')',0},{});
        }
    }
}
public class GenerateParenthesesSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr = solution.generateParentheses(2).toArray(new String[0]);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}