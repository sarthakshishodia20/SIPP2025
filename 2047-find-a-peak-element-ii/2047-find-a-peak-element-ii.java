class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int maxRow=getMaxRow(mid,mat);
            int left=mid-1>=0?mat[maxRow][mid-1]:-1;
            int right=mid+1<m?mat[maxRow][mid+1]:-1;
            if(mat[maxRow][mid]>left && mat[maxRow][mid]>right){
                return new int[]{maxRow,mid};
            }
            else if(mat[maxRow][mid]<left){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    public static int getMaxRow(int col,int[][] arr){
        int maxIndex=-1;
        int maxElement=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i][col]>maxElement){
                maxIndex=i;
                maxElement=arr[i][col];
            }
        }
        return maxIndex;
    }
}