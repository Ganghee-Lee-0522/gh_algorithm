import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int removed = 0;
            int prev = 0;
            boolean possible = true;
            
            for(int i = 0; i < rocks.length; i++) {
                int gap = rocks[i] - prev;
                
                if(gap < mid) {
                    removed++;
                    if(removed > n) {
                        possible = false;
                        break;
                    }
                }
                else {
                    prev = rocks[i];
                }
            }
            
            if(distance - prev < mid) {
                removed++;
                if(removed > n) {
                    possible = false;
                }
            }
            
            if(possible) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}