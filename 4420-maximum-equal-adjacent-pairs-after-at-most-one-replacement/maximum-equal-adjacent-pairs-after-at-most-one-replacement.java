class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int max=0;
        int ans1=0,ans2=0;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            int x=Math.min(nums[i],nums[i+1]);
            int y=Math.max(nums[i],nums[i+1]);
            String key=x+"|"+y;
            
            if(nums[i]==nums[i+1]){
                ans1++;
            }
            else{
                map.put(key,map.getOrDefault(key,0)+1);
                ans2=Math.max(ans2,map.get(key));
            }
        }
        return ans1+ans2;
    }
}