class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (isVowel(ch)) {
                list.add(ch);
                arr[i] = '#'; 
            }
        }
        Collections.sort(list);
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '#') {
                arr[i] = list.get(index++);
            }
        }
        return new String(arr); 
    }
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
