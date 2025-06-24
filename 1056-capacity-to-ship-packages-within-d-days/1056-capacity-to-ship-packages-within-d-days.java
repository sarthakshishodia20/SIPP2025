class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        int ans = -1;
        for (int ele : weights) {
            low = Math.max(ele, low); 
            high += ele;              
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, weights, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int cap, int[] wt, int requirement) {
        int load = 0;
        int day = 1;
        for (int i = 0; i < wt.length; i++) {
            if (load + wt[i] > cap) {
                load = wt[i];  
                day = day + 1;
            } else {
                load = load + wt[i];
            }
        }
        return day <= requirement;
    }
}
