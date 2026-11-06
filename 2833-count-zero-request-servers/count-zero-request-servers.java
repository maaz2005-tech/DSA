class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int q=queries.length,m=logs.length;
        int querr[][]=new int[q][2];
        int arr[]=new int[q];
        for(int i=0;i<q;i++){
            querr[i][0]=queries[i];
            querr[i][1]=i;
        }
        Arrays.sort(querr,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));
        int i=0;
        int j=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int[] qu:querr){
            int end=qu[0];
            int start=end-x;
            // expand 
            while(j<m && logs[j][1]<=end){
                map.put(logs[j][0],map.getOrDefault(logs[j][0],0)+1);
                j++;
            }
            // shrink
            while(i<m && logs[i][1]<start){
                if(map.get(logs[i][0])==1){
                    map.remove(logs[i][0]);
                }
                else{
                    map.put(logs[i][0],map.get(logs[i][0])-1);
                }
                i++;
            }
            arr[qu[1]]=n-map.size();
        }
        return arr;
    }
}