class Solution {
    final int MOD=1_000_000_007;
    public int smallestUniqueSubarray(int[] nums) {
        // rolling hash formula :
        // hash=Sigma0tom-1(nums[i]*p^m-1-i )%MOD
        // newHash=[(oldHash- outgoing*p^m-1)*p + incoming]%MOD
        // generally p is 31 (BASE)
        // m-> size of window
        int n=nums.length,BASE=52;
        int l=1,r=n;
        while(l<=r){
            int len=l+(r-l)/2;
            Map<Long,Integer> map=new HashMap<>();
            Long hash=0L;
            long power=1;
            for(int p=1;p<len;p++){
                power=(power*BASE)%MOD;
            }
            for(int i=0;i<len;i++){
                hash=(hash*BASE + nums[i])%MOD;
            }
            map.put(hash,1);
            for(int i=len;i<n;i++){
                hash =(hash - nums[i-len] * power % MOD + MOD) % MOD;
                hash =(hash * BASE + nums[i]) % MOD;
                map.put(hash,map.getOrDefault(hash,0)+1);
            }
            boolean unique=false;
            for(Long key:map.keySet()){
                if(map.get(key)==1){
                    unique=true;
                    break;
                }  
            }
            if(unique){
                r=len-1;
            }
            else{
                l=len+1;
            }
        }
        return l;
    }
}