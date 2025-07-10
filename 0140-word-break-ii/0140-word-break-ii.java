class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);        
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        word(s, set, result, tempList);
        List<String> finalResult = new ArrayList<>();
        for (List<String> list : result) {
            finalResult.add(String.join(" ", list));
        }
        return finalResult;
    }
    public static void word(String s, HashSet<String> set, List<List<String>> result, List<String> list) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i + 1);
            if (set.contains(left)) {
                list.add(left); 
                word(s.substring(i + 1), set, result, list);
                list.remove(list.size() - 1); 
            }
        }
    }
}
