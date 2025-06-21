class Solution {
    static class Pair implements Comparable<Pair>{
        char ch;
        int frequency;
        public Pair(char ch,int frequency){
            this.ch=ch;
            this.frequency=frequency;
        }
        @Override
        public int compareTo(Pair p2){
            if(this.frequency==p2.frequency){
                return p2.ch-this.ch;
            }
            else{
                return p2.frequency-this.frequency;
            }
        }
    }
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        while(pq.size()>1){
            Pair first=pq.poll();
            Pair second=pq.poll();
            sb.append(first.ch);
            sb.append(second.ch);
            if(--first.frequency>0){
                pq.add(first);
            }
            if(--second.frequency>0){
                pq.add(second);
            }
        }
        if(!pq.isEmpty()){
            if(pq.peek().frequency>1){
                return "";
            }
            else{
                sb.append(pq.peek().ch);
            }
        }
        return sb.toString();
    }
}