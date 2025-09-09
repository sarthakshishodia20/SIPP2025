class Solution {
    static class Pair implements Comparable<Pair>{
        String num;
        int index;
        Pair(String num, int index){
            this.num = num;
            this.index = index;
        }
        @Override
        public int compareTo(Pair p2){
            int cmp = this.num.compareTo(p2.num);
            if(cmp == 0) return this.index - p2.index;
            return cmp;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        List<Integer> ans=new ArrayList<>();
        int index=0;   
        for(int[] query:queries)
        {
            int k=query[0];
            int trimed=query[1];
            PriorityQueue<Pair> pq=new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                String n=getTrimmed(nums[i],trimed);
                pq.add(new Pair(n,i));
            }
            for(int i=0;i<k-1;i++){
                pq.poll();
            }
            ans.add(pq.poll().index);
        }
        index=0;
        int[] Ans=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            Ans[index++]=ans.get(i);
        }
        return Ans;
    }

    public static String getTrimmed(String str,int k){
        return str.substring(str.length()-k);
    }
}
