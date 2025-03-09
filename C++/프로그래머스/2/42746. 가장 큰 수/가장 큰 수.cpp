#include <bits/stdc++.h>

using namespace std;

bool compare(string a, string b) {
    return a + b > b + a;
}
string solution(vector<int> numbers) {
    string answer = "";
    bool isZero = true;
    vector<string> s;
    
    for(int n : numbers) {
        s.push_back(to_string(n));
        if(n != 0) {
            isZero = false;
        }
    }
    if(isZero) {
        return "0";
    }
    
    sort(s.begin(), s.end(), compare);
    for(string st: s) {
        answer += st;
    }
    return answer;
}