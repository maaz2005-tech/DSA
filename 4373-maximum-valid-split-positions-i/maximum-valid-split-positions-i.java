class Solution {
    int gcd(int a,int b){
        while(b>0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    int solve(List<Integer> list){
        int ans=0;
        int n=list.size();
        int pref[]=new int[n];
        pref[0]=list.get(0);
        int suff[]=new int[n];
        suff[n-1]=list.get(n-1);
        for(int i=1;i<n;i++){
            int x=list.get(i);
            pref[i]=gcd(x,pref[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            int x=list.get(i);
            suff[i]=gcd(x,suff[i+1]);
        }
        for(int i=0;i<n-1;i++){
            if(pref[i]==suff[i+1]){
                ans++;
            }
        }
        return ans;
    }
    public int maxValidSplits(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int x:nums) list.add(x);
        int n=nums.length;
        int ans=solve(list);
        for(int i=0;i<n;i++){
            list.remove(i);
            ans=Math.max(ans,solve(list));
            list.add(i,nums[i]);
        }
        return ans;
    }
}