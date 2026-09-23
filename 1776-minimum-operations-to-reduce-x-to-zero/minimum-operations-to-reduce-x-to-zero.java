class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        Map<Integer,Integer> pref=new HashMap<>();
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==x) ans=Math.min(ans,i+1);
            pref.put(sum,i);
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            if(sum==x) ans=Math.min(ans,n-i);
            int rem=x-sum;
            if(pref.containsKey(rem) && pref.get(rem)<i){
                ans= Math.min(ans,n-i+pref.get(rem)+1);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}