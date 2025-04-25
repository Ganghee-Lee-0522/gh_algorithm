import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int[] supo1 = {5, 1, 2, 3, 4};
        int[] supo2 = {5, 2, 1, 2, 3, 2, 4, 2};
        int[] supo3 = {5, 3, 3, 1, 1, 2, 2, 4, 4, 5};
        
        int[] grade = {0, 0, 0, 0};
        
        for(int idx = 1; idx <= answers.length; idx++) {
            if(supo1[idx % 5] == answers[idx - 1]) {
                grade[1]++;
                if(grade[1] > grade[0]) {
                    grade[0] = grade[1];
                }
            }
            if(supo2[idx % 8] == answers[idx - 1]) {
                grade[2]++;
                if(grade[2] > grade[0]) {
                    grade[0] = grade[2];
                }
            }
            if(supo3[idx % 10] == answers[idx - 1]) {
                grade[3]++;
                if(grade[3] > grade[0]) {
                    grade[0] = grade[3];
                }
            }            
        }
        
        for(int idx = 1; idx < 4; idx++) {
            if(grade[0] == grade[idx]) {
                answer.add(idx);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}