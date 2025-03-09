#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int cur = arr[0];
    answer.push_back(cur);
    
    for(int a : arr) {
        if(a == cur) {
            continue;
        }
        cur = a;
        answer.push_back(cur);
    }

    return answer;
}