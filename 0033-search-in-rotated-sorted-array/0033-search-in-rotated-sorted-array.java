class Solution {
    public static int getMin(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int n = arr.length;
        if (arr[low] <= arr[high]) return 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            if (arr[prev] > arr[mid] && arr[next] > arr[mid]) {
                return mid;
            } else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
    public int search(int[] nums, int target) {
        int minIndex = getMin(nums);
        int leftSearch = findInLeft(nums, 0, minIndex - 1, target);
        int rightSearch = findInRight(nums, minIndex, nums.length - 1, target);   
        if (leftSearch != -1) return leftSearch;
        return rightSearch;
    }

    public static int findInLeft(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int findInRight(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
