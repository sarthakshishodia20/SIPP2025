class Solution {
    // Variation of LCS
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // bs jitne lcs ki length hogi utne hi toh connect kr paenge bina cross kie 
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}