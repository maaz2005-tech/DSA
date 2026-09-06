class Solution {
    public int countGoodRotations(int[] nums) {
        long s1=0;
        long s2=0;
        int n=nums.length;
        for(int i=0;i<n/2;i++){
            s1+=nums[i];
        }
        for(int i=n/2;i<n;i++){
            s2+=nums[i];
        }
        int l=0; // s2+=
        int r=n/2; // s1+=

        int ans=0;
        // n/2 times
        while(r<n){
            int x=nums[l++]; // s2+=
            int y=nums[r++]; // s1+=
            
            s1-=x;
            s1+=y;
            s2-=y;
            s2+=x;
            if(s1>s2) ans++;
        }
        r=0;
        while(l<n){
            int x=nums[l++]; // s2+=
            int y=nums[r++]; // s1+=
            s1-=x;
            s1+=y;
            s2-=y;
            s2+=x;
            if(s1>s2) ans++;
        }
        return ans;
    }
}