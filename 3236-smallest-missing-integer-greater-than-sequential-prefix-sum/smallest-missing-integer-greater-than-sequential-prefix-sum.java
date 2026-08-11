class Solution {
    
    public int missingInteger(int[] nums) {
        int i=1,sum=nums[0];
        while(i<nums.length){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
                i++;
            }
            else break;

        }
        Set<Integer> set=new HashSet<>();
        for(int x:nums) set.add(x);
        while(true){
            if(!set.contains(sum)){
                return sum;
            }
            else sum++;
        }
    }
}