#include <bits/stdc++.h>
using namespace std;

struct customComp {
    bool operator() (const string& a, const string& b) const {
        if(a.size() == b.size()) {
            return a < b;
        }
        else {
            return a.size() < b.size();
        }
    }
};

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n;
    string s;
    set<string, customComp> set;
    
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> s;
        set.insert(s);
    }
    
    for(auto& a : set) {
        cout << a << '\n';
    }
    
    return 0;
}