class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int firstIndex = -1;
        int secondIndex = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                secondIndex = i + 1;
                break;
            }
        }
        if (firstIndex > 0 && secondIndex < n - 1 && firstIndex < secondIndex) {
            return exist(nums, firstIndex)             
                && exist3(nums, firstIndex, secondIndex) 
                && exist2(nums, secondIndex);            
        } else {
            return false;
        }
    }
    public static boolean exist(int[] arr, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] < arr[i + 1]) continue;
            else return false;
        }
        return true;
    }
    public static boolean exist3(int[] arr, int s, int e) {
        for (int i = s; i < e; i++) {
            if (arr[i] > arr[i + 1]) continue;
            else return false;
        }
        return true;
    }
    public static boolean exist2(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) continue;
            else return false;
        }
        return true;
    }
}
