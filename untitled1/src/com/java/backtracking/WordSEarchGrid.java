package com.java.backtracking;

public class WordSEarchGrid {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Save the character at the current position
        char temp = board[row][col];
        // Mark the cell as visited
        board[row][col] = '#';

        // Explore all four directions
        boolean found = dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row, col + 1, index + 1) ||
                dfs(board, word, row, col - 1, index + 1);

        // Restore the character at the current position
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {
        WordSEarchGrid ws = new WordSEarchGrid();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(ws.exist(board, "ABCCED")); // Output: true
        System.out.println(ws.exist(board, "SEE")); // Output: true
        System.out.println(ws.exist(board, "ABCB")); // Output: false
    }
}