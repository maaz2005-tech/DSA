class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length;
        Integer index[]=new Integer[n];
        for(int i=0;i<n;i++){
            index[i]=i;
        }
        Arrays.sort(index,(a,b)->position[a]-position[b]);
        float time[]=new float[n];
        for(int i:index){
            time[i]=((float)target-position[i])/speed[i];
        }
       float max=time[index[n-1]];
        int count=1;
        for(int i=n-2;i>=0;i--){
            if(max<time[index[i]]){
                max=time[index[i]];
                count++;
            }
        }
        return count;

    }
}