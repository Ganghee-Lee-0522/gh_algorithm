#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    string answer = "";
    // unordered_multiset<string> ums에 참가자 insert
    // ums에서 완주자를 삭제
    // ums에 남은 선수의 이름을 return
    unordered_multiset<string> ums(participant.begin(), participant.end());
    for(string s : completion) {
        ums.erase(ums.find(s)); // ums.erase(s)를 쓰면 중복 포함 모두 삭제 됨!
    }
    answer = *ums.begin();
    return answer;
}