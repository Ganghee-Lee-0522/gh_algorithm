class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int length = nums.size();
        k = k % length;

        int count = 0;  // 몇 개의 요소를 이동했는지
        for (int i = 0; count < length; i++) {
            int cur = i;  // 현재 위치
            int prev = nums[i];  // 현재 위치 값 저장

            do {
                int next = (cur + k) % length;  // 다음 위치
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;  // 이동한 요소 개수 증가
            } while (i != cur);  // 사이클로 생각..시작점으로 돌아오면 다음 시작점으로 넘어감
        }
    }
};
