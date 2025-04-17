import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<Integer> answer = new ArrayList<>();
        int ent = brown + yellow;
        int leng;
        // width * length = brown + yellow
        // width <= brown
        for(int width = brown; width >= ent / width; width--) {
            if(ent % width == 0) {
                leng = ent / width;
                if(yellow == (width - 2) * (leng - 2) && brown == (width + leng - 2) * 2) {
                    answer.add(width);
                    answer.add(leng);
                    break;
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}