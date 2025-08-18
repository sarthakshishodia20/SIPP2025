class Solution {
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int ele:citations){
            pq.add(ele);
        }
        int hIndex=0;
        while(!pq.isEmpty() && pq.peek()>hIndex){
            pq.poll();
            hIndex++;
        }
        return hIndex;

    }
}