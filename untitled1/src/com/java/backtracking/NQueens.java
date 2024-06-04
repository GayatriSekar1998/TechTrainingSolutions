package com.java.backtracking;

import java.util.Scanner;

public class NQueens {
    private static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the size of the chessboard (N): ");
        N = scanner.nextInt();
        solveNQueens(); // Call the solveNQueens method to find and print the solutions
    }
    private static void solveNQueens() {
        int[][] board = new int[N][N]; // Initialize a 2D array to represent the chessboard
        if (solveNQueensUtil(board, 0)) {
            System.out.println("Solution found:");
            printSolution(board); // If a solution is found, print the chessboard configuration
        } else {
            System.out.println("No solution exists.");
        }
    }
    private static boolean solveNQueensUtil(int[][] board, int col) {
        if (col >= N) {
            return true; // All queens are placed successfully, base case for recursion
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place the queen in the current position
                if (solveNQueensUtil(board, col + 1)) {
                    return true; // Recursively try to place queens in the next column
                }
                board[i][col] = 0; // Backtrack if placing the queen didn't lead to a solution
            }
        }
        return false; // No solution found in this column
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            // Check if there is a queen in the same row, column, or diagonal
            if (board[row][i] == 1 || board[i][col] == 1 || (row - i >= 0 && board[row - i][col - i] == 1) || (row + i < N && board[row + i][col - i] == 1)) {
                return false; // If a conflict is found, return false
            }
        }

        return true; // No conflicts found, it's safe to place a queen in this position
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " "); // Print the chessboard configuration
            }
            System.out.println();
        }
    }
}