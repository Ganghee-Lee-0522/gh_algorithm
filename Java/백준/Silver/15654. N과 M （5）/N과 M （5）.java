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
	    inputArr = new int[N];
	    visited = new boolean[N];
	    answer = new int[M];
	    
	    for(int i = 0; i < N; i++) {
	        inputArr[i] = sc.nextInt();
	    }
	    
	    Arrays.sort(inputArr);
	    
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
	    
	    for(int i = 0; i < N; i++) {
	        if(!visited[i]) {
	            visited[i] = true;
	            answer[depth] = inputArr[i];
	            dfs(depth + 1);
	            visited[i] = false;
	        }
	    }
	}
}