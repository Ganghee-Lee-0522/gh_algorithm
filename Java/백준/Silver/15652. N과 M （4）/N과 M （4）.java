import java.util.*;

public class Main
{
    static int N, M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    
	    answer = new int[M];
	    
	    dfs(1, 0); // cur, depth
	    System.out.print(sb);
	    
	    return;
	}
	
	public static void dfs(int cur, int depth) {
	    if(depth == M) {
	        for(int i : answer) {
	            sb.append(i).append(" ");
	        }
	        sb.append("\n");
	        
	        return;
	    }
	    
	    for(int idx = cur; idx <= N; idx++) {
	        answer[depth] = idx;
	        dfs(idx, depth + 1);
	    }
	    
	    return;
	}
}