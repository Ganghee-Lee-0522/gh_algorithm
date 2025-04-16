import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant) {
            map.compute(s, (k, v) -> v == null ? 1 : v + 1);
        }
        for(String s : completion) {
            if(map.get(s) > 1) {
                map.put(s, map.get(s) - 1);
            }
            else {
                map.remove(s);
            }
        }
        for(String s : map.keySet()) {
            return s;
        }
        
        return "";
    }
}