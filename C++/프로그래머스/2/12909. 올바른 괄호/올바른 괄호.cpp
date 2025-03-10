#include<bits/stdc++.h>

using namespace std;

bool solution(string s)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    stack<int> st;
    
    for(char e : s) {
        if(e == '(') {
            st.push(')');
        }
        else if(e == st.top()) {
            st.pop();
        }
        else {
            return false;
        }
    }
    
    if(!st.empty()) {
        return false;
    }
    return true;
}