class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }
        Arrays.sort(arr,(a,b)->{
            return a[0]-b[0];
        });
        float time[]=new float[n];
        for(int i=0;i<n;i++){
            time[i]=((float)target-arr[i][0])/arr[i][1];
        }
        float max=time[n-1];
        int count=1;
        for(int i=n-2;i>=0;i--){
            if(max<time[i]){
                max=time[i];
                count++;
            }
        }
        return count;


        // int n=speed.length;
        // Integer index[]=new Integer[n];
        // for(int i=0;i<n;i++){
        //     index[i]=i;
        // }
        // Arrays.sort(index,(a,b)->position[a]-position[b]);
        // for(int i=0;i<n;i++) System.out.print(position[index[i]]+" ");
        // float time[]=new float[n];
        // for(int i:index){
        //     time[i]=((float)target-position[i])/speed[i];
        // }
        // float min=time[0];
        // int count=1;
        // for(int i:index){
        //     if(min>time[i]){
        //         min=time[i];
        //         count++;
        //     }
        // }
        // return count;

    }
}