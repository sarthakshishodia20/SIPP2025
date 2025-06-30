class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return ans;
        // int count = 0;
        // int[] prefix = new int[nums.length];
        // prefix[0] = nums[0];

        // // Calculate the prefix sum array
        // for (int i = 1; i < nums.length; i++) {
        //     prefix[i] = prefix[i - 1] + nums[i];
        // }

        // // Iterate through all subarrays and check if their sum is equal to k
        // for (int i = 0; i < nums.length; i++) {
        //     int start = i;
        //     for (int j = i; j < nums.length; j++) {
        //         int end = j;
        //         int sum = (start == 0) ? prefix[end] : (prefix[end] - prefix[start - 1]);
        //         if (sum == k) {
        //             count++;
        //         }
        //     }
        // }

        // return count;
    }
}