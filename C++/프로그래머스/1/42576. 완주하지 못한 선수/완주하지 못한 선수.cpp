#include <bits/stdc++.h>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    unordered_multiset<string> set(participant.begin(), participant.end());
    for(string& c : completion) {
        auto it = set.find(c);
        if(it != set.end()) {
            set.erase(it);
        }
    }
    
    return *set.begin();
}