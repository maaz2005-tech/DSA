class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max=0;
        for(int light:lights){
            max=Math.max(light,max);
        }
        int ans=0;
        for(int time:arrivalTime){
            int r=time%period;
            int wt=(r<max)?0:(period-r);
            ans=Math.max(ans,wt);
        }
        return ans;
    }
}