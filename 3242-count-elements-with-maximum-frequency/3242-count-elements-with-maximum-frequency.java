class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int maxFreq=0;
        for(int i:map.values()){
            maxFreq=Math.max(maxFreq,i);
        }
        int count=0;
        for(int i:map.values()){
            if(i==maxFreq){
                count++;
            }
        }
        return count*maxFreq;
    }
}