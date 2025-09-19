class Solution {
    static class Pair implements Comparable<Pair> {
        int xValue;
        int yValue;
        public Pair(int xvalue, int yvalue) {
            this.xValue = xvalue;
            this.yValue = yvalue;
        }
        @Override
        public int compareTo(Pair p2) {
            return Integer.compare(p2.yValue, this.yValue);
        }
    }
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < x.length; i++) {
            pq.add(new Pair(x[i], y[i]));
        }
        Set<Integer> usedX = new HashSet<>();
        int maxSum = 0;
        int count = 0;
        while (!pq.isEmpty() && count < 3) {
            Pair curr = pq.poll();
            if (!usedX.contains(curr.xValue)) { 
                maxSum += curr.yValue;
                usedX.add(curr.xValue);
                count++;
            }
        }
        return (count < 3) ? -1 : maxSum;
    }
}
