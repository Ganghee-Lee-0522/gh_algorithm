class Solution {
public:
    bool canJump(vector<int>& nums) {
        ios::sync_with_stdio(0);
        cin.tie(0);
        int board[20050]= {1, 0, };
        int max = nums.size();
        for(int i = 0; i < max; i++) {
            if(board[i] > 0) {
                for(int j = 1; j <= nums[i]; j++) {
                board[i + j] = 1;
                }
            }
            if(board[max - 1] > 0) {
                return true;
            }
        }

        return false;
        
    }
};