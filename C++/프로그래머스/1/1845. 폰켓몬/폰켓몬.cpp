#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    /* erase & unique 사용 풀이 */
    // int answer = nums.size() / 2;
    // sort(nums.begin(), nums.end());
    // nums.erase(unique(nums.begin(), nums.end()), nums.end());
    // return answer < nums.size() ? answer : nums.size();
    
    /* set 사용 풀이 */
    int answer = nums.size() / 2;
    set <int> s;
    for(int e : nums) {
        s.insert(e);
    }
    return answer < s.size() ? answer : s.size();
}