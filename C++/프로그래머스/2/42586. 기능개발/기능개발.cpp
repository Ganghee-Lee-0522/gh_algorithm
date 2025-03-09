#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> d;
    
    for(int p = 0; p < progresses.size(); p++) {
        int cnt = 1;
        
        cnt = (100 - progresses[p]) / speeds[p];
        if((100 - progresses[p]) % speeds[p]) cnt++;
        
        d.push(cnt);
    }
    
    while(!d.empty()) {
        int cnt = 1;
        int prev = d.front(); d.pop();
        
        while(!d.empty() && d.front() <= prev) {
            d.front(); d.pop();
            cnt++;
        }
        answer.push_back(cnt);
    }
    return answer;
}