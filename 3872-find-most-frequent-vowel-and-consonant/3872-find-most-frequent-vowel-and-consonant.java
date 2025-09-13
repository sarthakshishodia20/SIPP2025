class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                continue;
            }
            else{
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        HashMap<Character,Integer> map1=new HashMap<>();
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                map1.put(c,map1.getOrDefault(c,0)+1);
            }
        }
        int max1=0;
        int max2=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            max1=Math.max(max1,entry.getValue());
        }
        for(Map.Entry<Character,Integer> entry:map1.entrySet()){
            max2=Math.max(max2,entry.getValue());
        }
        return max1+max2;
    }
    public static boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='o'||ch=='i'||ch=='u';
    }
}