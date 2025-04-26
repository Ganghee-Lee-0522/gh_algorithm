import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String s = sc.next();
	    StringBuilder sb = new StringBuilder(s);
	    if(sb.toString().equals(sb.reverse().toString())) {
	        System.out.print("1");
	    }
	    else {
	        System.out.print("0");
	    }
	    
	    return;
	}
}