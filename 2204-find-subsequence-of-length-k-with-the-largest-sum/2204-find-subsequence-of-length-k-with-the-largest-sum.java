class Solution {
    static class Pair implements Comparable<Pair>{
        int element;
        int index;
        public Pair(int element,int index){
            this.element=element;
            this.index=index;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.element-this.element;
        }
    }
    static class IndexFind implements Comparable<IndexFind>{
        int element;
        int index;
        public IndexFind(int element,int index){
            this.element=element;
            this.index=index;
        }
        @Override
        public int compareTo(IndexFind P2){
            return this.index-P2.index;
        }
    }
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
        }
        List<Pair> list=new ArrayList<>();
        while(k-->0){
            list.add(pq.poll());
        }
        PriorityQueue<IndexFind> Pq=new PriorityQueue<>();
        for(Pair p:list){
            Pq.add(new IndexFind(p.element,p.index));
        }
        List<Integer> ans=new ArrayList<>();
        while(!Pq.isEmpty()){
            IndexFind current=Pq.poll();
            ans.add(current.element);
        }
        int[] Ans=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            Ans[i]=ans.get(i);
        }
        return Ans;
    }
}