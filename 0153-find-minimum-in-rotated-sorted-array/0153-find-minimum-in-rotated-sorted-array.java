class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int n=nums.length;
        // int ans=;
        if(nums.length==1){
            return nums[0];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int prev=(mid+n-1)%n;
            int next=(mid+1)%n;
            if(nums[prev]>nums[mid] && nums[next]>nums[mid]){
                return nums[mid];
            }
            else if(nums[mid]<nums[high]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    
}