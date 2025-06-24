class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi=Integer.MIN_VALUE;
        for(int ele:nums){
            maxi=Math.max(maxi,ele);
        }
        int low=1;
        int high=maxi;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isSmaller(mid,nums,threshold)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean isSmaller(int val,int[] arr,int t){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=(int)Math.ceil((double)arr[i]/val);
        }
        return sum<=t;
    }
}