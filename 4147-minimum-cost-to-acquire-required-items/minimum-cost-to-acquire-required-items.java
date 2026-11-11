class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long cost=0;
        if(costBoth<cost1+cost2){
            int minNeed=Math.min(need1,need2);
            cost+=(long)costBoth*minNeed;
            need2-=minNeed;
            need1-=minNeed;
        }
        if(costBoth<cost1){
            // System.out.println(need1+" run "+need2);
            cost+=(long)costBoth*need1;
            need1=0;
            need2=Math.max(0,need2-need1);
            // System.out.println(need1+" run "+need2);
        }
        if(costBoth<cost2){
            cost+=(long) costBoth*need2;
            need2=0;
            need1=Math.max(0,need1-need2);
        }
        cost+=(long)need1*cost1;
        cost+=(long)need2*cost2;
        return cost;
    }
}