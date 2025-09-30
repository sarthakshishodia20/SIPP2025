class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int[] visited=new int[baskets.length];
        int count=0;
        for(int i=0;i<fruits.length;i++){
            int fruit=fruits[i];
            for(int j=0;j<baskets.length;j++){
                int basket=baskets[j];
                if(visited[j]==0 && fruit<=basket){
                    count++;
                    visited[j]=1;
                    break;
                }
            }
        }
        return fruits.length-count;
    }
}