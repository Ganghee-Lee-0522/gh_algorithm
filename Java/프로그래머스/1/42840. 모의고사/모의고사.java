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
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 1; i <= answers.length; i++) {
            if(answers[i - 1] == boardA[i % 5]) {
                cnt[1]++;
            }
            if(answers[i - 1] == boardB[i % 8]) {
                cnt[2]++;
            }
            if(answers[i - 1] == boardC[i % 10]) {
                cnt[3]++;
            }
        }
        
        if(cnt[1] > cnt[2] && cnt[1] > cnt[3]) {
            cnt[0] = cnt[1];
        }
        else if(cnt[2] > cnt[3]) {
            cnt[0] = cnt[2];
        }
        else {
            cnt[0] = cnt[3];
        }
        
        int idx = 0;
        
        for(int i = 1; i <= 3; i++) {
            if(cnt[i] == cnt[0]) {
                answerList.add(i);
            }
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}