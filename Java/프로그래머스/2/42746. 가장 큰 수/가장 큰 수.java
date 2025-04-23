import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] boxed = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> (b.toString() + a.toString()).compareTo(a.toString() + b.toString()));
        StringBuilder sb = new StringBuilder();
        for(int num : boxed) {
            sb.append(num);
        }
        if(sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}