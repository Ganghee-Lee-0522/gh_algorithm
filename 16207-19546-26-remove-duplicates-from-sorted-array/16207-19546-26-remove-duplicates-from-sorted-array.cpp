class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int idx = 1, tmp = nums[0];

        for(int i = 1; i < nums.size(); i++) {
            if(nums[i] != tmp) {
                tmp = nums[i];
                nums[idx++] = tmp;
            }
        }
        return idx;
    }
};