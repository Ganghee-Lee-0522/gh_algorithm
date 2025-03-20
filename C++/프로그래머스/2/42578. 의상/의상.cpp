#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<string>> clothes) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // unordered_set us에 옷의 종류를 저장
    // unordered_multimap umm 에 종류별 옷을 저장 {종류, 이름}
    // umm의 종류별 개수 + 1 을 모두 곱하고 -1 하여 return
    unordered_set<string> us;
    unordered_multimap<string, string> umm;
    int cnt = 1;
    for(int i = 0; i < clothes.size(); i++) {
        us.insert(clothes[i][1]);
        umm.insert({clothes[i][1], clothes[i][0]});
    }
    for(auto a : us) {
        cnt *= (umm.count(a) + 1);
    }
    return --cnt;
}