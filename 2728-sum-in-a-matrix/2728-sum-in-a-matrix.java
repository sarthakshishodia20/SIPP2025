class Solution {
    public int matrixSum(int[][] nums) {
        int score=0;
        for(int[] row:nums){
            Arrays.sort(row);
            reverse(row);
        }
        for(int j=0;j<nums[0].length;j++){
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<nums.length;i++){
                pq.add(nums[i][j]);
            }
            score+=pq.poll();
        }
        return score;
    }
    public static void reverse(int[] arr){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        Collections.reverse(list);
        for(int i=0;i<arr.length;i++){
            arr[i]=list.get(i);
        }
    }
}