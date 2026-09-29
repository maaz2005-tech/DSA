class Solution {
    public int[] rearrangeArray(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int ans[]=new int[nums.length];
        int i=0;
        while(true){
            boolean flag=false;
            for(int x:map.keySet()){
                if(map.get(x)==0){
                    continue;
                }
                ans[i++]=x;
                flag=true;
                map.put(x,map.get(x)-1);
            }
            if(!flag) break;
        }
        return ans;
    }
}