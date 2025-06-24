class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = -1;
        int high = 0;
        for (int ele : piles) {
            high = Math.max(high, ele);
        }
        int low = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long requiredTime = getTime(mid, piles); 
            if (requiredTime <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static long getTime(int time, int[] piles) {
        long totalTime = 0;
        for (int ele : piles) {
            totalTime += (long) Math.ceil((double) ele / time);
        }
        return totalTime;
    }
}
