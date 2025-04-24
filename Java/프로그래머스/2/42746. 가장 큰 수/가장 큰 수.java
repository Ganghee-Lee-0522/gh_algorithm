import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Integer[] boxed = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> (b.toString() + a.toString()).compareTo(a.toString() + b.toString()));
        for(int num : boxed) {
            sb.append(num);
        }
        
        if(sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}