import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        int max = A.length;
        
        for(int a : A) {
            while(idx < max && a >= B[idx]) {
                idx++;
            }
            if(idx >= max) {
                break;
            }
            if(B[idx] > a) {
                answer++;
                idx++;
            }
        }
        
        return answer;
    }
}