class Solution {
    static class Pair implements Comparable<Pair>{
        int value;
        int label;
        public Pair(int v,int l){
            this.value=v;
            this.label=l;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.value-this.value;
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<values.length;i++){
            pq.add(new Pair(values[i],labels[i]));
        }
        int count=0;
        int sum=0;
        while(!pq.isEmpty() && count<numWanted){
            Pair curr=pq.poll();
            int used=map.getOrDefault(curr.label,0);
            if(used<useLimit){
                sum+=curr.value;
                map.put(curr.label,used+1);
                count++;
            }
        }
        return sum;
    }
}