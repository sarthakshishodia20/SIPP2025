class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int maxSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        while(j<n){
            sum+=nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            while(map.get(nums[j])>1){
                int leftVal=nums[i];
                sum=sum-leftVal;
                map.put(leftVal,map.get(leftVal)-1);
                if(map.get(leftVal)==0){
                    map.remove(leftVal);
                }
                i++;
            }
            j++;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}