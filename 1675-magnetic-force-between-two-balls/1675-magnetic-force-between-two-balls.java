class Solution {
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int low=1;
        int high=arr[arr.length-1]-arr[0];
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,arr,m)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int gap,int[] arr,int cows){
        int countCows=1;
        int last=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]-last>=gap){
                countCows++;
                last=arr[i];
            }
            if(countCows>=cows){
                return true;
            }
        }
        return false;
    }
}