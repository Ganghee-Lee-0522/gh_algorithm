#include <bits/stdc++.h>
using namespace std;

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int n, m;
    string title, ip;
    cin >> n >> m;
    
    map<string, int> name;
    vector<string> number(n + 1);
    
    for(int i = 1; i <= n; i++) {
        cin >> title;
        name.insert({title, i});
        number[i] = title;
    }
    
    for(int i = 0; i < m; i++) {
        cin >> ip;
        if(isdigit(ip[0])) {
            cout << number[stoi(ip)] << '\n';
        }
        else {
            cout << name[ip] << '\n';
        }
    }

    return 0;
}