class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < n - 1) {
                if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid + 1] > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (mid == 0) {
                if (n == 1 || nums[0] > nums[1]) return 0;
                else return 1;
            } else if (mid == n - 1) {
                if (nums[n - 1] > nums[n - 2]) return n - 1;
                else return n - 2;
            }
        }

        return -1; 
    }
}
