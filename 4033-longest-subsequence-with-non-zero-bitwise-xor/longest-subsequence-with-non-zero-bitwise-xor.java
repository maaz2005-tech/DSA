class Solution {
    public int longestSubsequence(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int curr=0;
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
            curr^=x;
        }
        if(curr>0) return n;
        for(int x:map.keySet()){
            if((x^curr)>0) return n-1;
        }
        return 0;
    }
}