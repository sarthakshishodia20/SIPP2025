class Solution {
    static class Pair implements Comparable<Pair>{
        int element;
        int frequency;
        public Pair(int element,int frequency){
            this.element=element;
            this.frequency=frequency;
        }
        @Override
        public int compareTo(Pair p2){
            return this.frequency-p2.frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().element);
        }
        int[] Ans=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            Ans[i]=ans.get(i);
        }
        return Ans;

    }
}