import java.util.*;

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] boardA = {5, 1, 2, 3, 4};
        int[] boardB = {5, 2, 1, 2, 3, 2, 4, 2};
        int[] boardC = {5, 3, 3, 1, 1, 2, 2, 4, 4, 5};
        int[] cnt = new int[4];
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 1; i <= answers.length; i++) {
            if(boardA[i % 5] == answers[i - 1]) {
                cnt[1]++;
            }
            if(boardB[i % 8] == answers[i - 1]) {
                cnt[2]++;
            }
            if(boardC[i % 10] == answers[i - 1]) {
                cnt[3]++;
            }
        }
        
        cnt[0] = Math.max(cnt[1], Math.max(cnt[2], cnt[3]));
        for(int i = 1; i <= 3; i++) {
            if(cnt[0] == cnt[i]) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}