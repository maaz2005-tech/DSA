class Solution {
    static final long INF=Long.MAX_VALUE;
    long minimumOperations(HashMap<Integer,Integer> map,int mid){
        // System.out.print(k+" "+list.size());
        // for(int i=0;i<k;i++) System.out.print(list.get(i)+" ");
        // System.out.println();
        long ans=0;
        for(int x:map.keySet()) ans+=(Math.abs(x-mid)*map.get(x));
        return ans;
    }
    public long solve(long nums[],int i,int k,int x){
        if(k==0) return 0L;
        if(i>=nums.length) return INF;
        if(dp[i][k]!=null) return dp[i][k];
        Long ans=solve(nums,i+1,k,x);
        long take=solve(nums,i+x,k-1,x);
        if (take != INF ) {
            ans = Math.min(ans, take + nums[i]);
        }
        return dp[i][k]=ans;
    }
    Long dp[][];
    public long minOperations(int[] nums, int x, int k) {
        // atleast k non overlapping subarrays of size x in nums
        int n=nums.length;
        long minOps[]=new long[n-(x-1)];
        // PriorityQueue<Integer> p1=new PriorityQueue<>(Comparator.reverseOrder());
        // PriorityQueue<Integer> p2=new PriorityQueue<>();
        // for(int i=0;i<x;i++) {
        //     p1.add(nums[i]);
        //     p2.add(p1.remove());
        //     if(p2.size()>p1.size()){
        //         p1.add(p2.remove());
        //     }
        // }
        // int mid=p1.peek();
        // // System.out.println(mid);
        // for(int i=0;i<x;i++){
        //     minOps[0]+=Math.abs((long)nums[i]-mid);
        // }
        // // System.out.print(minOps[0]);
        // for(int i=1;i<=n-x;i++){
        //     p1=new PriorityQueue<>(Comparator.reverseOrder());
        //     p2=new PriorityQueue<>();
        //     for(int j=i;j<i+x;j++){
        //         p1.add(nums[j]);
        //         p2.add(p1.remove());
        //         if(p2.size()>p1.size()){
        //             p1.add(p2.remove());
        //         }
        //     }
        //     mid=p1.peek();
        //     // System.out.println(mid);
        //     for(int j=i;j<i+x;j++){
        //         minOps[i]+=Math.abs((long)nums[j]-mid);
        //     } // optimized
        // }
        // for(int i=0;i<minOps.length;i++) System.out.print(minOps[i]+" "); // correct 




        // long[] minOps = new long[n - x + 1];

        PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> hi = new PriorityQueue<>();
        Map<Integer, Integer> delayed = new HashMap<>();   // lazy-deletion counts
        long loSum = 0, hiSum = 0;
        int loSize = 0, hiSize = 0;

        for (int i = 0; i < n; i++) {
            // 1. add nums[i]
            if (lo.isEmpty() || nums[i] <= lo.peek()) {
                lo.add(nums[i]); loSum += nums[i]; loSize++;
            } else {
                hi.add(nums[i]); hiSum += nums[i]; hiSize++;
            }

            // 2. remove element leaving the window
            if (i >= x) {
                int out = nums[i - x];
                delayed.merge(out, 1, Integer::sum);
                if (out <= lo.peek()) {
                    loSum -= out; loSize--;
                    if (out == lo.peek()) prune(lo, delayed);
                } else {
                    hiSum -= out; hiSize--;
                    if (!hi.isEmpty() && out == hi.peek()) prune(hi, delayed);
                }
            }

            // 3. rebalance so loSize == hiSize or hiSize + 1
            while (loSize > hiSize + 1) {
                int v = lo.poll(); loSum -= v; loSize--;
                hi.add(v);         hiSum += v; hiSize++;
                prune(lo, delayed);
            }
            while (loSize < hiSize) {
                int v = hi.poll(); hiSum -= v; hiSize--;
                lo.add(v);         loSum += v; loSize++;
                prune(hi, delayed);
            }

            // 4. window complete -> compute cost in O(1)
            if (i >= x - 1) {
                long mid = lo.peek();
                minOps[i - x + 1] = mid * loSize - loSum + hiSum - mid * hiSize;
            }
        }


        this.dp=new Long[minOps.length][k+1];
        return solve(minOps,0,k,x);
        // return 1L;
    }
    void prune(PriorityQueue<Integer> heap, Map<Integer, Integer> delayed) {
        while (!heap.isEmpty()) {
            int top = heap.peek();
            int c = delayed.getOrDefault(top, 0);
            if (c == 0) break;
            if (c == 1) delayed.remove(top); else delayed.put(top, c - 1);
            heap.poll();
        }
    }
}