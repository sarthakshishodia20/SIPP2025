class Solution {
    static class Pair implements Comparable<Pair>{
        int element;
        int difference;
        public Pair(int ele,int diff){
            this.element=ele;
            this.difference=diff;
        }
        @Override
        public int compareTo(Pair p2){
            if(this.difference==p2.difference){
                return this.element-p2.element;
            }
            else{
                return this.difference-p2.difference;
            }
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            int element=arr[i];
            int difference=Math.abs(arr[i]-x);
            pq.add(new Pair(element,difference));
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll().element);
        }
        Collections.sort(ans);
        return ans;
    }
}