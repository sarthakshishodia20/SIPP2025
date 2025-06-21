class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int score = 0;
        
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            
            if (first > 0 && second > 0) {
                score++;
                first--;
                second--;
                if (first > 0) {
                    pq.add(first);
                }
                if (second > 0) {
                    pq.add(second);
                }
            }
        }
        return score;
    }
}
