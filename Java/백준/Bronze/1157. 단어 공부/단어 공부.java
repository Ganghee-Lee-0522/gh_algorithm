import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Map<Character, Integer> map = new HashMap<>();
	    Scanner sc = new Scanner(System.in);
	    String st = sc.next();
	    st = st.toUpperCase();
	    
	    for(int i = 0; i < st.length(); i++) {
	        map.compute(st.charAt(i), (k, v) -> v == null ? 1 : v + 1);
	    }
	    
	    List<Character> arr = new ArrayList<>(map.keySet());
	    arr.sort((a, b) -> {
	        return map.get(b) - map.get(a);
	    });
	    
	    StringBuilder sb = new StringBuilder();
	    for(char c : arr) {
	        sb.append(map.get(c));
	    }
	    if(sb.length() > 1 && sb.charAt(0) == sb.charAt(1)) {
	        System.out.print("?");
	        return;
	    }
	    System.out.print(arr.get(0));
	    return;
	}
}