class Solution {
    public String[] largestString(int[] nums) {
        int n=nums.length;
        String[] ans=new String[n];
        for(int i=0;i<n;i++){
            int x=nums[i];
            StringBuilder sb=new StringBuilder();
            while(x>0){
                for(int j=25;j>=0;j--){
                    int y=(int)Math.pow(2,j);
                    if(y<=x){
                        sb.append((char)('a'+j));
                        x-=y;
                        break;
                    }
                }
            }
            ans[i]=sb.toString();
        }
        return ans;
    }
}