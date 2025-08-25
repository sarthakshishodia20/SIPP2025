class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                diagonalMap.putIfAbsent(key, new ArrayList<>());
                diagonalMap.get(key).add(mat[i][j]);
            }
        }
        int index = 0;
        for (int key = 0; key < m + n - 1; key++) {
            List<Integer> diagonal = diagonalMap.get(key);
            if (key % 2 == 0) {
                Collections.reverse(diagonal);
            }
            for (int num : diagonal) {
                result[index++] = num;
            }
        }
        return result;
    }
}