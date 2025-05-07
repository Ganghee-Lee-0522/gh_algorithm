import java.util.*;

public class Main
{
    public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
		    arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {
		    int num = sc.nextInt();
		    find(num, 0, N - 1, arr);
		}
		System.out.print(sb.toString());
		sc.close();
		return;
	}
	
	public static void find(int num, int left, int right, int[] arr) {
	    if(left > right) {
	        sb.append("0\n");
	        return;
	    }
	    if(arr[(left + right) / 2] == num) {
	        sb.append("1\n");
	        return;
	    }
	    else if(arr[(left + right) / 2] > num) {
	        find(num, left, (left + right) / 2 - 1, arr);
	    }
	    else {
	        find(num, (left + right) / 2 + 1, right, arr);
	    }
	    
	    return;
	}
}