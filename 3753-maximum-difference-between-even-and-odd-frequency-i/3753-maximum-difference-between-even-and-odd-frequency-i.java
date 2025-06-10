class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE; 
        for (int freq : map.values()) {
            if (freq % 2 == 1) {
                if (freq > maxOdd) {
                    maxOdd = freq;
                }
            } else {
                if (freq < minEven) {
                    minEven = freq;
                }
            }
        }
        return maxOdd - minEven;
    }
}