class Solution {
    public static int maxi(int[] arr){
        int max=0;
        for(int ele:arr){
            max=Math.max(ele,max);
        }
        return max;
    }
    public static int sumi(int[] arr){
        int sum=0;
        for(int ele:arr){
            sum+=ele;
        }
        return sum;
    }
    public int splitArray(int[] nums, int k) {
        int low=maxi(nums);
        int high=sumi(nums);
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,nums,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int sumAllowed,int[] arr,int k){
        int student=1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+sum>sumAllowed){
                student++;
                sum=arr[i];
            }
            else{
                sum=sum+arr[i];
            }
        }
        return student<=k;
    }
}