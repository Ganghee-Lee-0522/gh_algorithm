#include <bits/stdc++.h>
#define X first
#define Y second
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int answer = 1, idx = 0;
    pair<int, int> cur;
    queue<pair<int, int>> q; // {다리 진입 시각, 트럭 무게 idx}
    q.push({answer, idx++});
    int weight_cnt = truck_weights[0];
    
    while(!q.empty()) {
        // 시간 증가
        answer++;
        
        // 트럭 하나 다리에서 out
        if(!q.empty() && answer - q.front().X >= bridge_length) {
            cur = q.front(); q.pop();
            // cout << "\n\ntime: " << answer << " 초\n ";
            // cout << "트럭 아웃: " << truck_weights[cur.Y] << ' ';
            weight_cnt -= truck_weights[cur.Y];
        }
        
        // 올릴 수 있는 트럭이라면 다리에 on
        if(idx < truck_weights.size() && 
           weight_cnt + truck_weights[idx] <= weight && q.size() + 1 <= bridge_length) {
            // cout << "\n\ntime: " << answer << " 초\n ";
            // cout << "트럭 인: " << truck_weights[idx] << ' ';
            q.push({answer, idx});
            weight_cnt += truck_weights[idx];
            idx++;
        }
    }
    
    return answer;
}