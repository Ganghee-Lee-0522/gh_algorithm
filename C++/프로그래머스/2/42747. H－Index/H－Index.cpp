#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> citations) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int answer = 0;
    // citations.size()와 citations 원소의 최댓값 중 더 작은 값을 max에 저장
    // if max == 0이면 0 반환 종료
    // citations >= max를 만족하는 citations의 원소가 max개 이상이면 max 반환 종료
    // 위 조건을 충족하지 않는 max에 대해 max--로 반복
    
    int tmp = citations[0];
    int size = citations.size();
    for(int i = 1; i < size; i++) {
        cout << "i: " << i << ", citaions[i]: " << citations[i] << '\n';
        if(citations[i] > tmp) {
            tmp = citations[i];
        }
    }
    int max = min(size, tmp);
    if(max == 0) return 0;
    
    while(max > 0) {
        for(int c : citations) {
            if(c >= max) answer++;
        }
        if(answer >= max) {
            answer = max;
            break;
        }
        answer = 0;
        max--;
    }
    return answer;
}