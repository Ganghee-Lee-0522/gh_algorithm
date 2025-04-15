#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n, m, ip;
    unordered_set<int> dict;
    
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> ip;
        dict.insert(ip);
    }
    
    cin >> m;
    for(int i = 0; i < m; i++) {
        cin >> ip;
        if(dict.find(ip) != dict.end()) {
            cout << 1 << ' ';
        }
        else {
            cout << 0 << ' ';
        }
    }
    
    return 0;
}