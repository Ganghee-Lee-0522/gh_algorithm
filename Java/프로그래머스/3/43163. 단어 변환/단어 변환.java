import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Set<String> set = new HashSet<>();
        for(String s : words) {
            set.add(s);
        }
        if(!set.contains(target)) {
            return answer;
        }
        dfs(0, begin, target, words, visited);
        
        return answer;
    }
    
    public void dfs(int depth, String cur, String target, String[] words, boolean[] visited) {
        if(cur.equals(target)) {
            if(answer == 0) {
                answer = depth;
            }
            else {
                answer = Math.min(answer, depth);
            }
        }
        if(depth == words.length) {
            return;
        }
        
        for(int idx = 0; idx < words.length; idx++) {
            if(!visited[idx] && isPossible(cur, words[idx])) {
                visited[idx] = true;
                dfs(depth + 1, words[idx], target, words, visited);
                visited[idx] = false;
            }
        }
    }
    
    public boolean isPossible(String a, String b) {
        int size = a.length();
        int cnt = 0;
        for(int idx = 0; idx < size; idx++) {
            if(a.charAt(idx) == b.charAt(idx)) {
                cnt++;
            }
        }
        if(cnt == size - 1) {
            return true;
        }
        
        return false;
    }
}