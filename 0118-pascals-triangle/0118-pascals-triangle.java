class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {  
            List<Integer> tempList = new ArrayList<>();
            for (int col = 0; col <= row; col++) { 
                tempList.add(getNCR(row, col)); 
            }
            result.add(tempList);
        }
        return result;
    }

    public static int getNCR(int n, int c) {
        int ans = 1;
        for (int i = 0; i < c; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }
        return ans;
    }
}
