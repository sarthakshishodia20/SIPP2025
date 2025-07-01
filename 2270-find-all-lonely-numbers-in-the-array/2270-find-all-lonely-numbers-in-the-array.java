class Solution {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int element=nums[i];
            int nextElement=nums[i]+1;
            int prevElement=nums[i]-1;
            if(!map.containsKey(nextElement) && !map.containsKey(prevElement) && map.get(element)==1){
                ans.add(element);
            }
        }
        return ans;
    }
}