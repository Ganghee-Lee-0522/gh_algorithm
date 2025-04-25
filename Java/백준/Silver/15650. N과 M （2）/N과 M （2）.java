import java.util.*;

public class Main
{
    static int N, M;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        visited = new boolean[N + 1];
        answer = new int[M];
        dfs(0, 1);
        System.out.print(sb);
        
        return;
	}
    
    public static void dfs(int depth, int cur) {
        if(depth == M) {
            for(int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int idx = cur; idx <= N; idx++) {
            if(!visited[idx]) {
                visited[idx] = true;
                answer[depth] = idx;
                dfs(depth + 1, idx + 1);
                visited[idx] = false;
            }
        }
        
        return;
    }
}