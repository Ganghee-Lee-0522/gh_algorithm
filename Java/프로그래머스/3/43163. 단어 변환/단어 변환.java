import java.util.*;

class Solution {
    boolean[] visited;
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(String cur, String target, String[] words, boolean[] visited, int depth) {
        if(cur.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for(int nxt = 0; nxt < words.length; nxt++) {
            if(!visited[nxt] && isPossible(cur, words[nxt])) {
                visited[nxt] = true;
                dfs(words[nxt], target, words, visited, depth + 1);
                visited[nxt] = false;
            }
        }
    }
    
    public boolean isPossible(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 1;
    }
}