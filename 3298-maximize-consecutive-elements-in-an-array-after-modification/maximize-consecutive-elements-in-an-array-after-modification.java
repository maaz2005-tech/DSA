class Solution {
    int findIdx(int nums[],int l,int elem){
        int r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            
            if(nums[mid]>=elem){
                if(nums[mid]==elem) ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    int solve(int nums[],int i,int inc){
        if(dp[i][inc]!=-1) return dp[i][inc];
        int currVal=nums[i]+inc;
        int len=0;
        int j=findIdx(nums,i+1,currVal+1);
        if(j!=-1) len=Math.max(len,solve(nums,j,0));
        j=findIdx(nums,i+1,currVal);
        if(j!=-1) len=Math.max(len,solve(nums,j,1));
        return dp[i][inc]=len+1;
        
    }
    int dp[][];
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        this.dp=new int[nums.length][2];
        // for(int i[]:dp) Arrays.fill(i,-1);
        int res=1;
        for(int i=nums.length-1;i>=0;i--){
            for(int inc=0;inc<=1;inc++){
                int currVal=nums[i]+inc;
                int len=0;
                int j=findIdx(nums,i+1,currVal+1);
                if(j!=-1) len=Math.max(len,dp[j][0]);
                j=findIdx(nums,i+1,currVal);
                if(j!=-1) len=Math.max(len,dp[j][1]);
                dp[i][inc]=len+1;
            }
            res=Math.max(Math.max(res,dp[i][0]),dp[i][1]);
            // System.out.println(res);
        }
        return res;
    }
}