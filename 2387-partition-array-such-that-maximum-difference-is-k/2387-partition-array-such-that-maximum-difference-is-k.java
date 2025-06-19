class Solution {
    public int partitionArray(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int ele:nums){
            pq.add(ele);
        }
        List<Integer> list=new ArrayList<>();
        list.add(pq.poll());//minimum Element;
        int count=1;
        while(!pq.isEmpty()){
            if(pq.peek()-list.get(0)<=k){
                list.add(pq.poll());
            }
            else{
                list.clear();
                list.add(pq.poll());
                count++;
            }
        }
        return count;
    }
}