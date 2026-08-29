class Solution {
    public int minTaps(int n, int[] ranges) {
        int intervals[][]=new int[n+1][2];
        for(int i=0;i<=n;i++){
            intervals[i][0]=Math.max(0,i-ranges[i]);
            intervals[i][1]=Math.min(n,i+ranges[i]);
        }
        // Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[1]-b[0],a[1]-a[0]);
        });
        int curr[]=intervals[0];
        int ans=1;
        for(int i=1;i<=n;i++){
            if(intervals[i][0]>curr[1]) return -1;
            if(intervals[i][1]<=curr[1]){
                continue;
            }
            int b=curr[1];
            while(i<=n && intervals[i][0]<=curr[1]){
                b=Math.max(b,intervals[i][1]);
                i++;
            }
            curr[1]=b;
            ans++;
            i--;
        }
        if(curr[0]!=0 || curr[1]!=n) return -1;
        return ans;
    }
}