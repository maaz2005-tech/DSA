class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        int ans=-1;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i] || arr[i][1]==i) continue;
            int curr=arr[i][0];
            int j=i;
            while(!vis[j]){
                vis[j]=true;
                curr=curr&arr[j][0];
                j=arr[j][1];
            }
            if(ans==-1) ans=curr;
            else ans=ans&curr;
        }
        return ans==-1?0:ans;
    }
}