class Solution {
    static class Activity{
        int starttime;
        int endtime;
        public Activity(int s,int e){
            this.starttime=s;
            this.endtime=e;
        }
    }
    public int findLongestChain(int[][] pairs) {
        List<Activity> list=new ArrayList<>();
        for(int[] p:pairs){
            int s=p[0];
            int e=p[1];
            list.add(new Activity(s,e));
        }
        Collections.sort(list,(a,b)->a.endtime-b.endtime);
        int count=1;
        int lastEnd=list.get(0).endtime;
        for(int i=1;i<list.size();i++){
            if(list.get(i).starttime>lastEnd){
                count++;
                lastEnd=list.get(i).endtime;
            }
        }
        return count;
    }
}