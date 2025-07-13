class Solution {
    static class Pair{
        int start;
        int end;
        public Pair(int s,int e){
            this.start=s;
            this.end=e;
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            else{
                return a[0]-b[0];
            }
        });
        List<Pair> list=new ArrayList<>();
        for(int[] interval:intervals){
            int start=interval[0];
            int end=interval[1];
            Pair newPair=new Pair(start,end);
            list.add(newPair);
        }
        List<Pair> merged=new ArrayList<>();
        for(Pair curr:list){
            if(merged.isEmpty() || curr.start>merged.get(merged.size()-1).end){
                merged.add(curr);
            }
            else{
                Pair last=merged.get(merged.size()-1);
                last.end=Math.max(curr.end,last.end);
            }
        }
        int[][] ans=new int[merged.size()][2];
        for(int i=0;i<merged.size();i++){
            ans[i][0]=merged.get(i).start;
            ans[i][1]=merged.get(i).end;
        }
        return ans;
    }
}