#include <bits/stdc++.h>

using namespace std;

struct pqComp {
    bool operator() (tuple<int, int, int> a, tuple<int, int, int> b) {
    return get<1>(a) > get<1>(b);
    }
};

struct rqComp {
    bool operator() (tuple<int, int, int> a, tuple<int, int, int> b) {
        if (get<2>(a) != get<2>(b)) return get<2>(a) > get<2>(b); // 소요 시간 기준 오름차순
        if (get<1>(a) != get<1>(b)) return get<1>(a) > get<1>(b); // 요청 시각 기준 오름차순
        return get<0>(a) > get<0>(b); // 작업 번호 기준 오름차순 (추가됨)
    }
};

int solution(vector<vector<int>> jobs) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int answer = 0;
    // pq 선언: priority_queue min 작업 요청 시점
    // rq 선언: priority_queue min소요시간/min요청시각/min작업번호
    // st 선언: stack
    // 현재 시각 선언: cur = 0
    // do: 현재 시각보다 요청 시각이 작거나 같은 원소를 rq 저장
    //     rq.top()을 꺼내고 반환 시각(현재 시각 + 작업 소요시간)) 계산하여 st 저장, cur += 소요시간
    // while: !pq.empty()
    priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, pqComp> pq;
    priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>, rqComp> rq;
    int cur = 0;
    
    for(int idx = 0; idx < jobs.size(); idx++) { // 요청 시각 기준 pq 삽입
        pq.push(make_tuple(idx, jobs[idx][0], jobs[idx][1]));
    }
    
    while (!pq.empty() || !rq.empty()) {
        // rq가 비었고 pq에 작업이 남아 있다면 cur을 다음 요청 작업 시간으로 이동
        if (rq.empty() && !pq.empty()) {
            cur = max(cur, get<1>(pq.top()));
        }

        // 현재 시각(cur) 이전에 요청된 모든 작업을 rq로 이동
        while (!pq.empty() && get<1>(pq.top()) <= cur) {
            rq.push(pq.top());
            pq.pop();
        }

        if (!rq.empty()) {
            // rq에서 소요 시간이 짧은 작업을 수행
            tuple<int, int, int> now = rq.top();
            rq.pop();

            cur += get<2>(now);
            answer += cur - get<1>(now);  // 총 대기 시간 계산
        }
    }
    
    
    return answer / jobs.size();
}