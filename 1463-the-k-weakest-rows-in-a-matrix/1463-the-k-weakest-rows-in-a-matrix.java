class Solution {
    static class Pair implements Comparable<Pair> {
        int onesCount;
        int index;
        public Pair(int onesCount, int index) {
            this.onesCount = onesCount;
            this.index = index;
        }
        @Override
        public int compareTo(Pair p2) {
            if (this.onesCount == p2.onesCount) {
                return this.index - p2.index;
            }
            return this.onesCount - p2.onesCount;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int count = countOnes(row); 
            pq.offer(new Pair(count, i));
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().index;  
        }
        return ans;
    }
    private int countOnes(int[] row) {
        int count = 0;
        for (int val : row) {
            if (val == 1) count++;
            else break;
        }
        return count;
    }
}
