import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    int[] cnt = new int[26];
	    for(int i = 0; i < 26; i++) {
	        cnt[i] = -1;
	    }
	    Scanner sc = new Scanner(System.in);
	    String s = sc.next();
	    StringBuilder sb = new StringBuilder(s);
	    for(int i = 0; i < sb.length(); i++) {
	        if(cnt[sb.charAt(i) - 'a'] == -1) {
	            cnt[sb.charAt(i) - 'a'] = i;
	        }
	    }
	    
	    for(int i : cnt) {
	        System.out.print(i + " ");
	    }
	}
}