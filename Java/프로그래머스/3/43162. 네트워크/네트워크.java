import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int cur) {
        visited[cur] = true;
        
        for(int nxt = 0; nxt < computers.length; nxt++) {
            if(computers[cur][nxt] == 1 && !visited[nxt]) {
                dfs(computers, nxt);
            }
        }
    }
}