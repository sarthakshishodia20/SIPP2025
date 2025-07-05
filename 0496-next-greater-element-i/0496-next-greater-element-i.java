class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = nextG(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nge[i]);
        }
        int[] ans = new int[nums1.length];
        int i = 0;
        for (int ele : nums1) {
            ans[i++] = map.get(ele);
        }
        return ans;
    }
    public static int[] nextG(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            nge[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        return nge;
    }
}
