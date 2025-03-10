#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> scoville, int K) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int answer =  0;
    priority_queue<int, vector<int>, greater<>> pq;
    for(int s : scoville) {
        pq.push(s);
    }
    while(pq.size() > 1 && pq.top() < K) {
        answer++;
        int a = pq.top(); pq.pop();
        int b = pq.top(); pq.pop();
        a += 2 * b;
        pq.push(a);
        if(pq.top() >= K) {
            break;
        }
    }
    if(pq.size() == 1 && pq.top() <= K) answer = -1;
    
    return answer;
}