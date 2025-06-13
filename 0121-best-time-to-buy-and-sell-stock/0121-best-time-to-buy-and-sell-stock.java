class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int n=prices.length;
        int profit=0;
        int ans=0;
        for(int i=1;i<n;i++){
            profit=prices[i]-mini;
            ans=Math.max(ans,profit);
            mini=Math.min(mini,prices[i]);
        }
        return ans;
    }
}