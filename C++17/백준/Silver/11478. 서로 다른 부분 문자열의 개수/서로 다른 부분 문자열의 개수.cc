#include <bits/stdc++.h>
using namespace std;

int main() {
    
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    string st;
    unordered_set<string> set;
    cin >> st;
    
    for(int i = 0; i < st.size(); i++) {
        for(int j = 1; i + j <= st.size(); j++) {
            set.insert(st.substr(i, j));
        }
    }
    
    cout << set.size();
    
    return 0;
}