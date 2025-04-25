import java.util.*;

public class Main
{
    static int N, M;
    static boolean[] visited;
    static int[] answer;
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    
	    visited = new boolean[N + 1];
	    answer = new int[M];
	    
	    dfs(0);
	    
	    return;
	}
	
	public static void dfs(int depth) {
	    if(depth == M) {
	        for(int i : answer) {
	            System.out.print(i + " ");
	        }
	        System.out.println();
	        return;
	    }
	    
	    for(int idx = 1; idx <= N; idx++) {
	        if(!visited[idx]) {
	            visited[idx] = true;
	            answer[depth] = idx;
	            dfs(depth + 1);
	            visited[idx] = false;
	        }
	    }
	    return;
	}
}