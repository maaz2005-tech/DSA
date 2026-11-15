class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD=1_000_000_007;
        int n =arr.length;
        long cumSum=arr[0];
        int oddSums=arr[0]%2==0?0:1;
        int evenSums=arr[0]%2==0?1:0;
        int ans=arr[0]%2==0?0:1;
        // System.out.println(ans+"|"+oddSums+"|"+evenSums);
        for(int i=1;i<n;i++){
            cumSum+=arr[i];
            if(cumSum%2==0){ // even -> odds+
                ans=(ans+oddSums)%MOD;
                evenSums++;
            }
            else{ // odd -> evens+
                ans=(ans+evenSums +1)%MOD;
                oddSums++;
            }
            // System.out.println(ans+"|"+oddSums+"|"+evenSums);
        }
        return ans;
    }
}