import java.util.*;

public class Main
{
    static int N, M;
    static int[] inputArr;
    static boolean[] visited;
    static int[] answer;
    static Set<String> set = new HashSet<>();
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
	    dfs(0); // depth
	    System.out.print(sb);
	    
	    return;
	}
	
	public static void dfs(int depth) {
	    if(depth == M) {
	        StringBuilder tmp = new StringBuilder();
	        for(int i : answer) {
	            tmp.append(i).append(" ");
	        }
	        if(!set.contains(tmp.toString())) {
	            set.add(tmp.toString());
	            sb.append(tmp).append("\n");
	        }
	        return;
	    }
	    
	    for(int idx = 0; idx < N; idx++) {
	        if(!visited[idx]) {
	            visited[idx] = true;
	            answer[depth] = inputArr[idx];
	            dfs(depth + 1);
	            visited[idx] =false;
	        }
	    }
	    return;
	}
}