import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int start = 0; start < s.length(); start++) {
            Stack<Character> st = new Stack<>();
            boolean flag = false;
            for(int i = 0; i < s.length(); i++) {
                int cur = (start + i) % s.length();
                if(s.charAt(cur) == '[' || s.charAt(cur) == '(' || s.charAt(cur) == '{') {
                    st.push(s.charAt(cur));
                }
                else if(st.empty()) {
                    flag = true;
                    break;
                }
                else if(s.charAt(cur) == ']' && st.peek() == '[') {
                    st.pop();
                }
                else if(s.charAt(cur) == ')' && st.peek() == '(') {
                    st.pop();
                }
                else if(s.charAt(cur) == '}' && st.peek() == '{') {
                    st.pop();
                }
                else {
                    flag = true;
                    break;
                }
            }
            
            if(!flag && st.size() == 0) {
                answer++;
            }
        }
        return answer;
    }
}