class Solution {
    static class Pair implements Comparable<Pair>{
        int element;
        int frequency;
        public Pair(int element, int frequency){
            this.element = element;
            this.frequency = frequency;
        }
        @Override
        public int compareTo(Pair p2){
            if(this.frequency == p2.frequency){
                return p2.element - this.element; 
            }
            return this.frequency - p2.frequency; 
        }
    }

    public int[] frequencySort(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : nums){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] ans = new int[nums.length];
        int index = 0;

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int element = current.element;
            int frequency = current.frequency;
            while(frequency-- > 0){
                ans[index++] = element;
            }
        }

        return ans;
    }
}
