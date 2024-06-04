package com.java.backtracking;

import java.util.*;

// m is the given matrix and n is the order of matrix
class RatMazeSolution {
    private static void solve(int i, int j, int a[][], int n, ArrayList < String > ans, String move,
                              int vis[][]) {
        //solve(0,0,m,3,"",arr vis)
        if (i == n - 1 && j == n - 1) {//i=0,j=0,n=2
            ans.add(move);
            return;
        }
        // downward
        if (i + 1 < n && vis[i + 1][j] == 0 && a[i + 1][j] == 1) {//i=0+1<2 (T) && v(1,0) -> T && a
            vis[i][j] = 1;
            solve(i + 1, j, a, n, ans, move + 'D', vis);
            vis[i][j] = 0;
        }
        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && a[i][j - 1] == 1) {
            vis[i][j] = 1;
            solve(i, j - 1, a, n, ans, move + 'L', vis);
            vis[i][j] = 0;
        }
        // right
        if (j + 1 < n && vis[i][j + 1] == 0 && a[i][j + 1] == 1) {//2
            vis[i][j] = 1;
            solve(i, j + 1, a, n, ans, move + 'R', vis);
            vis[i][j] = 0;
        }
        // upward
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && a[i - 1][j] == 1) {
            vis[i][j] = 1;
            solve(i - 1, j, a, n, ans, move + 'U', vis);
            vis[i][j] = 0;
        }
    }
    public static ArrayList < String > findPath(int[][] m, int n) {// m= {{1,1},{0,1}} n= 2
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        ArrayList < String > ans = new ArrayList < > ();
        if (m[0][0] == 1) {//m(0,0) = 1
            solve(0, 0, m, n, ans, "", vis);//solve(0,0,m,3,"",arr vis)
        }
        return ans;
    }
}
class RatMaze {
    public static void main(String[] args) {

        int n = 2;
        int[][] a = {{1,1},{0,1}};

        RatMazeSolution obj = new RatMazeSolution();
        ArrayList < String > res = obj.findPath(a, n);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}