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
	    
	    dfs(0);
	    System.out.print(sb);
	    
	    return;
	}
	
	public static void dfs(int depth) {
	    if(depth == M) {
	        for(int i : answer) {
	            sb.append(i).append(" ");
	        }
	        sb.append("\n");
	        return;
	    }
	    
	    for(int idx = 1; idx <= N; idx++) {
	        answer[depth] = idx;
	        dfs(depth + 1);
	    }
	    
	    return;
	}
}