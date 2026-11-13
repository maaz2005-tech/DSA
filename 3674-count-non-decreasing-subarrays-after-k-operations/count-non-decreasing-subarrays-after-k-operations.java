class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n=nums.length;
        long prefSum[]=new long[n];
        prefSum[0]=1L*nums[0];
        for(int i=1;i<n;i++){
            prefSum[i]=prefSum[i-1]+nums[i];
        }
        long minOps[]=new long[n];
        Stack<Integer> s=new Stack();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]<nums[i]){
                s.pop();
            }
            int m=s.isEmpty()?n:s.peek();
            minOps[i]=1L*nums[i]*(m-i)-(prefSum[m-1]-(i==0?0L:prefSum[i-1]));
            minOps[i]+=m==n?0:minOps[m];
            s.push(i);
        }
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int l=0,r=0;
        long res=0;
        while(r<n){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[r]){
                dq.removeLast();
            }
            dq.addLast(r);
            while(l<=r){
                int m=dq.peekFirst();
                long cost=minOps[l]-minOps[m] +( 1L* nums[m] * (r-m+1)- (prefSum[r]-(m==0?0:prefSum[m-1])));
                if(cost<=1L*k){
                    break;
                }
                l++;
                if(dq.peekFirst()<l) dq.removeFirst();
            }
            res+=(r++-l+1);
        }
        return res;
    }
}