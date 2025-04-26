import java.util.*;

public class Main
{
    static int N, M;
    static Set<Integer> inputSet = new TreeSet<>();
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    
	    answer = new int[M];
	    
	    for(int i = 0; i < N; i++) {
	        inputSet.add(sc.nextInt());
	    }
	    
	    dfs(0); // depth
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
	    
	    for(int i : inputSet) {
	        answer[depth] = i;
	        dfs(depth + 1);
	    }
	    return;
	}
}