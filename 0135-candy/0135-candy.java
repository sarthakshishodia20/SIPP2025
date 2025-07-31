class Solution {
    // Brute Force Approached

    // public int candy(int[] ratings) {
    //     int[] left=new int[ratings.length];
    //     int[] right=new int[ratings.length];
    //     int n=ratings.length;
    //     left[0]=1;
    //     right[n-1]=1;
    //     for(int i=1;i<ratings.length;i++){
    //         if(ratings[i]>ratings[i-1]){
    //             left[i]=left[i-1]+1;
    //         }
    //         else{
    //             left[i]=1;
    //         }
    //     }
    //     for(int i=n-2;i>=0;i--){
    //         if(ratings[i]>ratings[i+1]){
    //             right[i]=right[i+1]+1;
    //         }
    //         else{
    //             right[i]=1;
    //         }
    //     }
    //     int sum=0;
    //     for(int i=0;i<ratings.length;i++){
    //         sum+=Math.max(left[i],right[i]);
    //     }
    //     return sum;
    // }
    // better approached
     public int candy(int[] ratings) {
        int[] candies=new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        int n=ratings.length;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        int sum=0;
        for(int ele:candies){
            sum+=ele;
        }
        return sum;
    }
    
}