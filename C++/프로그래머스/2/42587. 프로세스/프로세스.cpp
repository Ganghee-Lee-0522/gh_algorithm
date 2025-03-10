#include <bits/stdc++.h>
#define X first
#define Y second
using namespace std;

bool comp(int i, int j) {
    return i > j;
}

int solution(vector<int> priorities, int location) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int answer = 0;
    
    // 큐에 프로세스를 (location, priorities) 쌍으로 삽입
    // priorities 배열을 내림차순 정렬
    // 큐를 돌며 cur의 priorities == priorities [i]이면 pop() 후 answer++, 불일치하면 다시 push()
    // 만약 cur의 location == location이면 return answer;
    queue<pair<int, int>> q;
    for(int i = 0; i < priorities.size(); i++) {
        q.push({i, priorities[i]});
    }
    sort(priorities.begin(), priorities.end(), comp);
    int idx = 0;
    
    for(int idx = 0; idx < priorities.size(); idx++) {
        pair<int, int> cur = q.front(); q.pop();
        while(cur.Y != priorities[idx]) {
            q.push(cur);
            cur = q.front(); q.pop();
        }
        answer++;
        if(cur.X == location) {
            break;
        }
    }
    return answer;
}