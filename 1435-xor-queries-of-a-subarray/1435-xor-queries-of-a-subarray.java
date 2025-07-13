class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int leftIndex = query[0];
            int rightIndex = query[1];
            int xor = CalculateXOR(arr, leftIndex, rightIndex);
            ans[index++] = xor;
        }
        return ans;
    }
    public static int CalculateXOR(int[] arr, int leftIndex, int rightIndex) {
        int xor = 0;
        for (int i = leftIndex; i <= rightIndex; i++) { 
            xor ^= arr[i];
        }
        return xor;
    }
}
