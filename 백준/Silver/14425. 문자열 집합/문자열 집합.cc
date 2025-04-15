#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n, m, answer = 0;
    string st;
    unordered_set<string> set;
    
    cin >> n >> m;
    
    for(int i = 0; i < n; i++) {
        cin >> st;
        set.insert(st);
    }
    
    for(int i = 0; i < m; i++) {
        cin >> st;
        if(set.find(st) != set.end()) {
            answer++;
        }
    }
    
    cout << answer;
}