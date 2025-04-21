import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int h = citations.length;
        while(h > 0) {
            int cnt = 0;
            for(int i : citations) {
                if(i >= h) {
                    cnt++;
                }
            }
            if(cnt >= h) {
                return h;
            }
            h--;
        }
        
        return h;
    }
}