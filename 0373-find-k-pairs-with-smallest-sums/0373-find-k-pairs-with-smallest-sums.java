class Solution {
    static class Pair implements Comparable<Pair> {
        int x1, x2, sum;
        public Pair(int x1, int x2, int sum) {
            this.x1 = x1;
            this.x2 = x2;
            this.sum = sum;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.sum - p2.sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                
                if (pq.size() < k) {
                    pq.add(new Pair(nums1[i], nums2[j], sum));
                } else if (sum < pq.peek().sum) {
                    pq.poll();
                    pq.add(new Pair(nums1[i], nums2[j], sum));
                } else {
                    break;
                }
            }
        }

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            result.add(Arrays.asList(current.x1, current.x2));
        }

        Collections.reverse(result);
        return result;
    }
}
