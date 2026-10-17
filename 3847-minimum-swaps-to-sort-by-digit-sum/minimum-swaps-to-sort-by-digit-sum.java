class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int sums[][]=new int[n][2];
        for(int i=0;i<n;i++){
            int x=nums[i],sum=0;
            while(x>0){
                sum+=(x%10);
                x/=10;
            }
            sums[i][0]=sum;
            sums[i][1]=i;
        }
        Arrays.sort(sums,(a,b)->{
            if(a[0]==b[0]){
                return nums[a[1]]-nums[b[1]];
            }
            return a[0]-b[0];
        });
        int ans=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i] || sums[i][1]==i)continue;
            else{
                int size=0;
                int j=i;
                while(!vis[j]){
                    size++;
                    vis[j]=true;
                    j=sums[j][1];
                }
                ans+=Math.max(0,size-1);
            }
        }
        return ans;
    }
}