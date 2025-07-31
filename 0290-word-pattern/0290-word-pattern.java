class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> wordToChar = new HashMap<>();
        HashMap<Character, String> charToWord = new HashMap<>();
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != words.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }
        }
        return true;
    }
}
