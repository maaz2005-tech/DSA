class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> busy=new PriorityQueue<>((a,b)->{ // {time,server_id}
            // if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        TreeSet<Integer> avail=new TreeSet<>();
        // Map<Integer,Integer> freq=new HashMap<>();
        int freq[]=new int[k];
        for(int i=0;i<k;i++) avail.add(i);
        int n=load.length;
        int max=0;
        for(int i=0;i<n;i++){
            while(!busy.isEmpty() && busy.peek()[0]<=arrival[i]){
                avail.add(busy.remove()[1]);
            }
            if(avail.isEmpty()){
                continue;
            }
            int sid=i%k;
            if(avail.contains(sid)){
                avail.remove(sid);
                busy.add(new int[]{arrival[i]+load[i],sid});
                // freq.put(sid,freq.getOrDefault(sid,0)+1);
                freq[sid]++;
                max=Math.max(max,freq[sid]);
                continue;
            }
            Integer next=avail.ceiling(sid);
            if(next==null){
                next=avail.first();
            }
            avail.remove(next);
            busy.add(new int[]{arrival[i]+load[i],next});
            // freq.put(next,freq.getOrDefault(next,0)+1);
            freq[next]++;
            max=Math.max(max,freq[next]);
        }
        List<Integer> res=new ArrayList<>();
        for(int x=0;x<k;x++){
            if(freq[x]==max) res.add(x);
            // System.out.println(x+"->"+freq.get(x));
        }
        return res;
    }
}