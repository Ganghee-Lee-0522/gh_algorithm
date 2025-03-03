class Solution {
public:
    int jump(vector<int>& nums) {

        if(nums.size() < 2) {
            return 0;
        }

        int board[10005];
        fill(board, board + nums.size(), 100000);
        board[0] = 0;
        queue<int> s;
        s.push(0);

        while(!s.empty()) {
            int cur = s.front(); s.pop();
            for(int i = 1; i <= nums[cur]; i++) {
                if(cur + i >= nums.size() - 1) {
                    return board[cur] + 1;
                }
                if(board[cur + i] > board[cur] + 1) {
                    board[cur + i] = board[cur] + 1;
                    s.push(cur + i);
                }
            }
        }

        return 0;
    }
};