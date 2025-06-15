class Solution {
    public int twoEggDrop(int n) {
        int[][] dp = new int[3][n + 1];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(2, n, dp);
    }
    public static int solve(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) {
            return f;
        }
        if (e == 1) {
            return f;
        }
        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        int mini = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int low = solve(e - 1, k - 1, dp);
            int high = solve(e, f - k, dp);   
            int temp = 1 + Math.max(low, high);
            mini = Math.min(mini, temp);
        }
        dp[e][f] = mini;
        return dp[e][f];
    }
}
