class Solution {
    static class Pair implements Comparable<Pair>{
        char character;
        int frequency;
        public Pair(char ch,int fre){
            this.character=ch;
            this.frequency=fre;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.frequency-this.frequency;
        }
    }
    public String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        while(!pq.isEmpty()){
            Pair current=pq.poll();
            char ch=current.character;
            int frequency=current.frequency;
            while(frequency>0){
                sb.append(ch);
                frequency--;
            }
        }
        return sb.toString();
    }
}