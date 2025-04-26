import java.util.*;

public class Main
{
    static int N, M;
    static Set<Integer> set = new TreeSet<>();
    static List<Integer> inputArr;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    M = sc.nextInt();
	    
	    answer = new int[M];
	    for(int i = 0; i < N; i++) {
	        set.add(sc.nextInt());
	    }
	    
	    inputArr = new ArrayList<>(set);
	    N = inputArr.size();
	    
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
	        answer[depth] = inputArr.get(idx);
	        dfs(idx, depth + 1);
	    }
	    
	    return;
	}
}