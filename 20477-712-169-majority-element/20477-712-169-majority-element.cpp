class Solution {
public:
    int majorityElement(vector<int>& nums) {
        // int board[2000000005] = {0, };
        int hlf = nums.size() / 2 + 1;
        for(int i = 0; i < nums.size(); i++) {
            int tmp = nums[i];
            int cnt = 1;
            
            // if(board[i + 1000000000] != 0) {
            //     continue;
            // }
            for(int j = i + 1; j < nums.size(); j++) {
                if(nums[j] == tmp) {
                    cnt++;
                    // cout << "i: " << i << ", j: " << j << ", cnt: " << cnt << '\n';
                }
                if(cnt >= hlf) {
                    return nums[i];
                }
            }
            // board[i + 1000000000] = 1;
        }

        return nums[0];
    }
};