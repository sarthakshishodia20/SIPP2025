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
            if(this.element==p2.element){
                return this.index-p2.index;
            }
            else{
                return this.element-p2.element;
            }
        }
    }
    public long findScore(int[] nums) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        long ans=0;
        int[] visited=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
        }
        while(!pq.isEmpty()){
            int currElement=pq.peek().element;
            int currIndex=pq.peek().index;
            pq.poll();

            if(visited[currIndex]==1){
                continue;
            }
            else{
                ans+=currElement;
                visited[currIndex]=1;
                if(currIndex-1>=0){
                    visited[currIndex-1]=1;
                }
                if(currIndex+1<nums.length){
                    visited[currIndex+1]=1;
                }
            }
        }
        return ans;
    }
}