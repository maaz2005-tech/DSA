class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int dp[]=new int[n];
        int hash[]=new int[n];
        Arrays.fill(hash,-1);
        int lastIndex=0,max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<1+dp[j]){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lastIndex=i;
            }
        }
        int i=lastIndex;
        while(i!=-1){
            list.add(nums[i]);
            i=hash[i];
        }
        return list;
    }
}