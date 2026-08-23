class Solution {
    Set<Integer> pf(int x){
        int ans=0;
        Set<Integer> set=new HashSet<>();
        while(x%2==0){
            x/=2;
            set.add(2);
        }
        for(int i=3;i*i<=x;i+=2){
            boolean flag=false;
            while(x%i==0){
                x/=i;
                if(!flag){
                    set.add(i);
                    ans+=1;
                }
                flag=true;
            }
        }
        if(x>1){
            set.add(x);
        } 
        return set;
    }
    public int longestSubarray(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Set<Integer>> primeFactors=new HashMap<>();
        for(int x:nums){
            if(!primeFactors.containsKey(x)){
                primeFactors.put(x,pf(x));
            }
        }
        int l=0,ans=0;
        Map<Integer,Integer> pfcount=new HashMap<>();
        for(int r=0;r<n;r++){
            Set<Integer> pfsR=primeFactors.get(nums[r]);
            for(int key:pfsR){
                pfcount.put(key,pfcount.getOrDefault(key,0)+1);
            }
            while(pfcount.size()>k){
                Set<Integer> pfsL=primeFactors.get(nums[l++]);
                for(int key:pfsL){
                    pfcount.put(key,pfcount.get(key)-1);
                    if(pfcount.get(key)==0){
                        pfcount.remove(key);
                    }
                }
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}