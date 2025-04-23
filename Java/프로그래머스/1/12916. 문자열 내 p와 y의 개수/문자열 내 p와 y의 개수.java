import java.util.*;

class Solution {
    boolean solution(String s) {
        int cnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == 'P' || cur == 'p') {
                cnt++;
            }
            else if(cur == 'Y' || cur == 'y') {
                cnt--;
            }
        }
        
        if(cnt == 0) {
            return true;
        }
        
        return false;
    }
}