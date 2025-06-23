class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=getFirst(nums,target);
        int second=getLast(nums,target);
        int[] ans=new int[2];
        Arrays.fill(ans,-1);
        ans[0]=first;
        ans[1]=second;
        return ans;
    }
    public static int getFirst(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static int getLast(int[] arr,int x){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            if(arr[mid]==x){
                ans=mid;
                low=mid+1;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}