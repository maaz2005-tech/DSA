class Solution {
    public int countStaircase(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> freq=new HashMap<>();
            Map<Integer,Integer> pos=new HashMap<>();
            int p=1;
            for(int j=i;j<n;j++){
                if(!pos.containsKey(nums[j])){
                    pos.put(nums[j],p++);
                }
                freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
                if(freq.get(nums[j])>pos.get(nums[j])) break;
                // System.out.println((p-1)+" "+i+"-"+j+" |"+((p-1)*p)/2);

                if((j-i+1)==(((p-1)*p)/2)){ 
                    ans++;
                    System.out.println(i+"-"+j);
                }
            }
        }
        return ans;
    }
}