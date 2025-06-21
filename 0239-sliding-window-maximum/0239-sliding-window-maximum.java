class Solution {
    static class Pair implements Comparable<Pair>{
        int val;
        int index;
        public Pair(int val, int index){
            this.val = val;
            this.index = index;
        }
        @Override 
        public int compareTo(Pair p2){
            return p2.val - this.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(nums[i], i));
        }
        ans[0] = pq.peek().val;
        int index = 1;
        for (int i = k; i < n; i++) {
            while (!pq.isEmpty() && pq.peek().index <= (i - k)) {
                pq.poll();
            }
            pq.add(new Pair(nums[i], i));
            ans[index++] = pq.peek().val;
        }
        return ans;
    }
}
