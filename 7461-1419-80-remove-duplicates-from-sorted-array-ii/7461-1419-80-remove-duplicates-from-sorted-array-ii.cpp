class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int idx = 1, tmp = nums[0], cnt = 1;
        for(int i = 1; i < nums.size(); i++) {
            if (nums[i] != tmp) { // 새로 등장하는 숫자면
                nums[idx++] = nums[i];
                cnt = 1;
            }
            else if(cnt > 0) { // 이전에 중복된 적 없으면
                nums[idx++] = tmp;
                cnt--;
            }

            tmp = nums[i];

        }
        return idx;
    }
};