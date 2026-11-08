class Solution {
    Set<List<Integer>> set=new HashSet<>();
    void solve(int nums[],boolean vis[],List<Integer> list){
        if(nums.length==list.size()){
            set.add(new ArrayList<>(list));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                list.add(nums[i]);
                solve(nums,vis,list);
                vis[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            List<Integer> list=new ArrayList<>();
            boolean vis[]=new boolean[nums.length];
            vis[i]=true;
            list.add(nums[i]);
            solve(nums,vis,list);
        }
        return new ArrayList<>(set);
    }
}