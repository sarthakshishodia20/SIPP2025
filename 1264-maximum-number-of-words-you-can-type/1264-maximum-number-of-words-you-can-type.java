class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set=new HashSet<>();
        for(char c:brokenLetters.toCharArray()){
            set.add(c);
        }
        int count=0;
        String[] arr=text.split(" ");
        for(String str:arr){
            for(char c:str.toCharArray()){
                if(set.contains(c)){
                    count++;
                    break;
                }
            }
        }
        return arr.length-count;
        
    }
}