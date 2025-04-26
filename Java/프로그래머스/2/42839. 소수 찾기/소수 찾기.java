import java.util.*;

class Solution {
    Set<Integer> set = new TreeSet<>();
    
    public int solution(String numbers) {
        
        int cnt = 0;
        
        for(int max = 1; max <= numbers.length(); max++) {
            int[] answer = new int[max];
            boolean[] visited = new boolean[numbers.length()];
            dfs(max, 0, numbers.length(), numbers, visited, answer);
        }
        
        for(int n : set) {
            if(available(n)) {
                cnt++;
            }
        }
        
        return cnt;
        
    }
    
    public void dfs(int max, int depth, int length, String numbers, boolean[] visited, int[] answer) {
        if(max == depth) {
            StringBuilder tmp = new StringBuilder();
            for(int i : answer) {
                tmp.append(i);
            }
            set.add(Integer.parseInt(tmp.toString()));
            
            return;
        }
        
        for(int idx = 0; idx < length; idx++) {
            if(!visited[idx]) {
                visited[idx] = true;
                answer[depth] = numbers.charAt(idx) - '0';
                dfs(max, depth + 1, length, numbers, visited, answer);
                visited[idx] = false;
            }
        }
        
        return;
    }
    
    public boolean available(int n) {
        if(n == 1 || n == 0) {
            return false;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}