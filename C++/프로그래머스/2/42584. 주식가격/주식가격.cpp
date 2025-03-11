#include <bits/stdc++.h>
#define X first
#define Y second

using namespace std;

vector<int> solution(vector<int> prices) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    vector<int> answer = prices;
    stack<pair<int, int>> st;
    st.push({0, prices[0]});
    pair<int, int> cur;
    
    for(int idx = 1; idx < prices.size(); idx++) {
        while(!st.empty() && st.top().Y > prices[idx]) {
            cur = st.top(); st.pop();
            answer[cur.X] = idx - cur.X;
        }
        st.push({idx, prices[idx]});
    }
    
    while(!st.empty()) {
        cur = st.top(); st.pop();
        answer[cur.X] = prices.size() - cur.X - 1;
    }
    
    return answer;
}