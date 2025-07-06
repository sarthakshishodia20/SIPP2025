class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0, maxAns = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        while (j < n) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if (map.size() <= 2) {
                maxAns = Math.max(maxAns, j - i + 1);
            }
            while (map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
                i++;
            }
            j++;
        }
        return maxAns;
    }
}
