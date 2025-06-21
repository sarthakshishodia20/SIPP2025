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
            if(this.frequency==p2.frequency){
                return p2.element-this.element;
            }
            else{
                return p2.frequency-this.frequency;
            }
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:barcodes){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        int[] ans=new int[barcodes.length];
        int index=0;
        while(pq.size()>1){
            Pair first=pq.poll();
            Pair second=pq.poll();
            ans[index++]=first.element;
            ans[index++]=second.element;
            if(--first.frequency>0){
                pq.add(first);
            }
            if(--second.frequency>0){
                pq.add(second);
            }
        }
        if(!pq.isEmpty()){
            if(pq.peek().frequency>1){
                return new int[]{0};
            }
            ans[index++]=pq.peek().element;
        }
        return ans;
    }
}