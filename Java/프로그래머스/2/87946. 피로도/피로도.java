class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(0, k, dungeons, visited);
        
        return answer;
    }
    
    public void dfs(int depth, int cur, int[][] dungeons, boolean[] visited) {
        
        answer = Math.max(depth, answer);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && cur >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth + 1, cur - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
    }
}