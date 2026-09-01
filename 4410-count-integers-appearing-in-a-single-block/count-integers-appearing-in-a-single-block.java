class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> l=new HashMap<>();
        Map<Integer,Integer> r=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            if(!l.containsKey(x)){
                l.put(x,i);
            }
            map.put(x,map.getOrDefault(x,0)+1);
            r.put(x,i);
        }
        int ans=0;
        for(int x:map.keySet()){
            if(map.get(x)==(r.get(x)-l.get(x)+1)){
                ans++;
            }
        }
        return ans;
    }
}