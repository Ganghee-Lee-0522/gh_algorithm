import java.util.*;

public class Main
{
    static int N, M;
    static boolean[] visited;
    static int[] inputArr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    
	    visited = new boolean[N];
	    inputArr = new int[N];
	    answer = new int[M];
	    
	    for(int i = 0; i < N; i++) {
	        inputArr[i] = sc.nextInt();
	    }
	    
	    Arrays.sort(inputArr);
	    dfs(0, 0); // cur, depth
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
	    
	    for(int idx = cur; idx < N; idx++) {
	        if(!visited[idx]) {
	            visited[idx] = true;
	            answer[depth] = inputArr[idx];
	            dfs(idx + 1, depth + 1);
	            visited[idx] = false;
	        }
	    }
	    return;
	}
}