class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int ele:bloomDay){
            low=Math.min(low,ele);
            high=Math.max(ele,high);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,bloomDay,m,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int day,int[] arr,int m,int k){
        int count=0;
        int noOfBouq=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
                if(count==k){
                    noOfBouq+=count/k;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }
        return noOfBouq>=m;
    }
}