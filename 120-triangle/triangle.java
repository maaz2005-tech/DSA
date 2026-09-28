class Solution {

    HashMap<String,Integer> dp=new HashMap<>();
    int solve(List<List<Integer>> triangle,int i,int j){
        if(i==triangle.size()) return 0;
        if(i>=triangle.get(i).size()) return Integer.MAX_VALUE;
        if(dp.containsKey(i+"|"+j)) return dp.get(i+"|"+j);
        int ans= Math.min(solve(triangle,i+1,j),solve(triangle,i+1,j+1))+triangle.get(i).get(j);
        dp.put(i+"|"+j,ans);
        return ans;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return solve(triangle,0,0);
    }
}