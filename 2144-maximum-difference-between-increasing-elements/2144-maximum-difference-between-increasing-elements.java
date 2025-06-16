class Solution {
    public int maximumDifference(int[] nums) {
        int maxDifference=-1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int firstElement=nums[i];
                int secondElement=nums[j];
                if(firstElement<secondElement){
                    maxDifference=Math.max(maxDifference,Math.abs(firstElement-secondElement));
                }
            }
        }
        return maxDifference;
    }
}