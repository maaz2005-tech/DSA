class Solution {
    int findGcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    int findLcm(int a,int b){
        return (a / findGcd(a, b)) * b;
    }
    public int maxLength(int[] nums) {
        int n=nums.length;
        int ans=1;
        for(int i=0;i<n;i++){
            int prod=nums[i];
            int lcm=nums[i];
            int gcd=nums[i];
            for(int j=i+1;j<n;j++){
                prod*=nums[j];
                gcd=findGcd(gcd,nums[j]);
                lcm=findLcm(lcm,nums[j]);
                if(prod==(lcm*gcd)) ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}