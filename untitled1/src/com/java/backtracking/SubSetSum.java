package com.java.backtracking;

import java.util.ArrayList;
import java.util.List;

class SubSetSum{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> comb, List<List<Integer>> res) {
        // If target is 0, we have found a valid combination
        if (target == 0) {
            // Append a copy of the current combination to the result list
            res.add(new ArrayList<>(comb));
            return;
        }
        // Iterate through the candidates array starting from the given index
        for (int i = start; i < candidates.length; i++) {
            // If the current candidate is greater than the remaining target, move on to the
            // next
            if (target < candidates[i]) {
                continue;
            }
            // Add the current candidate to the current combination
            comb.add(candidates[i]);
            // Recursively call the function with the updated combination and remaining
            // target
            backtrack(candidates, i, target - candidates[i], comb, res);
            // Backtrack by removing the last added candidate from the combination
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSetSum s = new SubSetSum();

        // Test case 2
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        System.out.println(s.combinationSum(candidates, target)); // expected output: []
    }
}