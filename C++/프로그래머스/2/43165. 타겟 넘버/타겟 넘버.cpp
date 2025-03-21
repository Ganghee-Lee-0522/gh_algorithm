#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

int solution(vector<int> numbers, int target) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    // queue<pair<int, int>> q {cnt, value} 의 value numbers[i]를 더하고/빼서 각각 q.push
    // numbers.size()만큼 반복한 후, q에 들어있는 원소 중 target과 같은 것의 개수를 return
    queue<pair<int, int>> q;
    q.push({0, 0});
    int answer = 0;
    
    while(!q.empty()) {
        pair<int, int> cur = q.front(); q.pop();
        if(cur.X + 1 == numbers.size()) { // 마지막 trial
            if(cur.Y + numbers[cur.X] == target || cur.Y - numbers[cur.X] == target) {
                answer++;
            }
            continue;
        }
        q.push({cur.X + 1, cur.Y + numbers[cur.X]});
        q.push({cur.X + 1, cur.Y - numbers[cur.X]});
    }

    return answer;
}