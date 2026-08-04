class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int num=nums[0];
        for(int x:nums){
            while(num!=x){
                ans.add(num++);
            }
            num++;
        }
        return ans;
    }
}