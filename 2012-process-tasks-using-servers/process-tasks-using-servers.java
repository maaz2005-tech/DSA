class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n=servers.length;
        int m=tasks.length;
        int res[]=new int[m];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){ // remaining time compare
                return a[1]-b[1];
            }
            else if(servers[a[0]]!=servers[b[0]]) { // weight
                return servers[a[0]]-servers[b[0]];
            }
            return a[0]-b[0]; // index
        }); // {server_idx,time}
        PriorityQueue<Integer> avail=new PriorityQueue<>((a,b)->{
            if(servers[a]==servers[b]){ // weight same
                return a-b;
            }
            return servers[a]-servers[b];
        });
        for(int i=0;i<n;i++){
            avail.add(i);
        }
        int time=0;
        for(int j=0;j<m;j++){
            if(avail.isEmpty() && pq.peek()[1]>time){
                time=pq.peek()[1];
            }
            while(!pq.isEmpty() && pq.peek()[1]<=time){
                avail.add(pq.remove()[0]);
            }
            boolean flag=false;
            while(!avail.isEmpty() && j<m && j<=time){
                int ind=avail.remove();
                pq.add(new int[]{ind,tasks[j]+time});
                res[j++]=ind;
                flag=true;
            }
            if(flag) j--;
            time+=1;
        }
        return res;
    }
}