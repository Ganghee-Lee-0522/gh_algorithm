import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] board = new int[triangle.length][triangle[triangle.length - 1].length];
        board[0][0] = triangle[0][0];
        if(triangle.length == 1) {
            return board[0][0];
        }
        board[1][0] = board[0][0] + triangle[1][0];
        board[1][1] = board[0][0] + triangle[1][1];
        if(triangle.length == 2) {
            return Math.max(board[1][0], board[1][1]);
        }
        for(int i = 2; i < triangle.length; i++) {
            board[i][0] = board[i - 1][0] + triangle[i][0];
            board[i][i] = board[i - 1][i - 1] + triangle[i][i];
            for(int j = 1; j < i; j++) {
                board[i][j] = Math.max(board[i - 1][j - 1], board[i - 1][j]) + triangle[i][j];
            }
        }
        for(int e : board[triangle.length - 1]) {
            answer = Math.max(e, answer);
        }
        return answer;
    }
}