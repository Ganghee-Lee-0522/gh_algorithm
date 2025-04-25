import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int h = n;
        
        while(n > 0) {
            int tmpCnt = 0;
            for(int cnt : citations) {
                if(cnt >= h) {
                    tmpCnt++;
                }
            }
            if(tmpCnt >= h) {
                return h;
            }
            h--;
        }
        
        return h;
    }
}