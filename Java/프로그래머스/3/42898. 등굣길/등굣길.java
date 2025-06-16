import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n][m];
        for(int[] e : puddles) {
            board[e[1] - 1][e[0] - 1] = -1;
        }
        board[0][0] = 1;
        for(int j = 1; j < m; j++) {
            if(board[0][j] == -1) {
                continue;
            }
            else if(board[0][j - 1] == -1) {
                board[0][j] = 0;
            }
            else {
                board[0][j] = board[0][j - 1];
            }
        }
        for(int i = 1; i < n; i++) {
            if(board[i][0] == -1) {
                continue;
            }
            else if(board[i - 1][0] == -1) {
                board[i][0] = 0;
            }
            else {
                board[i][0] = board[i - 1][0];
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(board[i][j] == -1) {
                    continue;
                }
                int prev1 = Math.max(board[i - 1][j], 0);
                int prev2 = Math.max(board[i][j - 1], 0);
                board[i][j] = (prev1 + prev2) % 1000000007;
            }
        }
        return board[n - 1][m - 1];
    }
}