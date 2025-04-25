import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String name = clothes[i][1];
            String kind = clothes[i][0];
            
            map.compute(name, (a, b) -> b == null ? 1 : b + 1);
        }
        
        List<String> cnt = new ArrayList<>(map.keySet());
        for(String name : cnt) {
            int clothesCnt = map.get(name);
            answer *= (clothesCnt + 1);
        }
        
        answer--;
        return answer;
    }
}