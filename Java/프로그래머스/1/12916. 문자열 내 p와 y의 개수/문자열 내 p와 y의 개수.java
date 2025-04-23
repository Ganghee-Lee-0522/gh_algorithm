import java.util.*;

class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == 'P' || c == 'p') {
                cnt++;
            }
            else if(c == 'Y' || c == 'y') {
                cnt--;
            }
        }
        
        return cnt == 0;
    }
}