import java.util.*;

class Count {
    String word;
    int cnt;
    Count(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        HashMap<String, Integer> board = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            board.put(words[i], 0);
        }
        
        if(board.get(target) == null) {
            return 0;
        }
        Queue<Count> queue = new ArrayDeque<>();
        queue.offer(new Count(begin, 0));
        while(!queue.isEmpty()) {
            Count cur = queue.poll();
            for(int i = 0; i < words.length; i++) {
                int tmp = 0;
                if(board.get(words[i]) == 0) {
                    for(int j = 0; j < begin.length(); j++) {
                        if(words[i].charAt(j) == cur.word.charAt(j)) {
                            tmp++;
                        }
                    }
                    if(tmp == cur.word.length() - 1) {
                        if(words[i].equals(target)) {
                            return cur.cnt + 1;
                        }
                        board.put(words[i], cur.cnt + 1);
                        queue.offer(new Count(words[i], cur.cnt + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}