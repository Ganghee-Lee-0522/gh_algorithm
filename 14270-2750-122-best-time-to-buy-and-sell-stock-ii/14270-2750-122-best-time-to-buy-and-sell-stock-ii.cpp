class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int cur, prof = 0, prev = prices[0];
        for(int i = 1; i < prices.size(); i++) {
            cur = prices[i];
            if(cur > prev) {
                prof += cur - prev;
            }
            prev = cur;
        }
        return prof;
    }
};