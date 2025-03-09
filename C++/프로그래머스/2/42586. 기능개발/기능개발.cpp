#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> due;
    
    for(int p = 0; p < progresses.size(); p++) {
        int cnt = 1;
        
        cnt = (100 - progresses[p]) / speeds[p];
        if((100 - progresses[p]) % speeds[p]) cnt++;
        
        due.push_back(cnt);
    }
    
    int cnt = 1;
    int prev = 0;
    int idx = 1;
    
    while(idx < progresses.size()) {
        while(idx < progresses.size() && due[idx] <= due[prev]) {
            idx++;
            cnt++;
        }
        answer.push_back(cnt);
        prev = idx;
        cnt = 0;
    }
    return answer;
}