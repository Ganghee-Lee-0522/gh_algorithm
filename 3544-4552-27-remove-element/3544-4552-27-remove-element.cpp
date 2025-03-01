class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int idx = 0;
        for(int i = 0; i < nums.size(); i++) {
            // nums[i] != val, nums[idx++] = nums[i]
            if(nums[i] != val) {
                nums[idx++] = nums[i];
            }
            // nums[i] == val, nums[i] = null
            // else {
            //     nums[i] = 0;
            // }
        }
        return idx;
    }
};