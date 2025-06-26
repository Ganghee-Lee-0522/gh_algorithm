class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int unit = 1; unit <= s.length() / 2; unit++) {
            int cnt = 1;
            String prev = s.substring(0, unit);
            StringBuilder sb = new StringBuilder();
            for(int i = unit; i <= s.length(); i += unit) {
                String cur = i + unit <= s.length() ? s.substring(i, i + unit) : s.substring(i);
                if(prev.equals(cur)) {
                    cnt++;
                }
                else {
                    if(cnt > 1) {
                        sb.append(cnt);
                    }
                    cnt = 1;
                    sb.append(prev);
                    prev = cur;
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