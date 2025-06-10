class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums.length - 1, nums, dp);
    }

    public static int helper(int index, int[] nums, int[] dp) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0]; 
        }
        if (dp[index] != -1) {
            return dp[index]; 
        }
        int pick = nums[index] + helper(index - 2, nums, dp);
        int notpick = helper(index - 1, nums, dp);
        dp[index] = Math.max(pick, notpick); 
        return dp[index];
    }
}
