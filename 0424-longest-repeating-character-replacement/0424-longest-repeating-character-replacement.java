class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        int maxLen = 0;
        int maxF = 0;
        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                maxF = Math.max(entry.getValue(), maxF);
            }
            while ((j - i + 1) - maxF > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);   
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                maxF = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    maxF = Math.max(entry.getValue(), maxF);
                }
                i++;
            }
            if ((j - i + 1) - maxF <= k) {
                maxLen = Math.max(maxLen, (j - i + 1));
            }
            j++;
        }
        return maxLen;
    }
}
