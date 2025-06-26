class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int leng = 1; leng <= s.length() / 2; leng++) {
            String prev = s.substring(0, leng);
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(int i = leng; i < s.length(); i += leng) {
                String cur = i + leng <= s.length() ? s.substring(i, i + leng) : s.substring(i);
                if(cur.equals(prev)) {
                    cnt++;
                }
                else {
                    if(cnt > 1) {
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    prev = cur;
                    cnt = 1;
                }
            }
            if(cnt > 1) {
                sb.append(cnt);
            }
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}