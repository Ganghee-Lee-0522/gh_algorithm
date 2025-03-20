#include <bits/stdc++.h>
using namespace std;

bool solution(vector<string> phone_book) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    // phone_book을 오름차순으로 정렬
    // i번째와 i+1번째 find 비교하여 찾으면 return false
    sort(phone_book.begin(), phone_book.end());
    for(int i = 0; i < phone_book.size() - 1; i++) {
        if(phone_book[i + 1].find(phone_book[i]) == 0) { // 접두어임
            return false;
        }
    }
    return true;
}