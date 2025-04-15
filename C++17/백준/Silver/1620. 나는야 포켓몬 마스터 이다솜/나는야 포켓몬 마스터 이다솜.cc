#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n, m;
    string st;
    cin >> n >> m;
    unordered_map<string, int> title;
    unordered_map<int, string> name;
    
    for(int i = 1; i <= n; i++) {
        cin >> st;
        title[st] = i;
        name[i] = st;
    }
    
    for(int i = 0; i < m; i++) {
        cin >> st;
        if(isdigit(st[0])) {
            cout << name[stoi(st)] << '\n';
        }
        else {
            cout << title[st] << '\n';
        }
    }
    
    return 0;
}