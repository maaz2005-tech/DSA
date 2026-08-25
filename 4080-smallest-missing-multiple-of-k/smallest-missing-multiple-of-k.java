class Solution {
    public int missingMultiple(int[] nums, int k) {
        int num=k;
        Set<Integer> set=new HashSet<>();
        for(int x:nums) set.add(x);
        while(true){
            if(!set.contains(num)){
                return num;
            }
            num+=k;
        }
        // return -1;
    }
}