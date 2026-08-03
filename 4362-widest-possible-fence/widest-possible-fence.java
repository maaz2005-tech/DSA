class Solution {
    public int maximumWidth(int[] planks) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int x:planks){
            freq.put(x,freq.getOrDefault(x,0)+1);
        }
        int n=planks.length;
        List<Integer> uniqueHeights=new ArrayList<>(freq.keySet());
        int unique=uniqueHeights.size();
        Map<Integer,Integer> pairCount=new HashMap<>();
        for(int i=0;i<unique;i++){
            int u=uniqueHeights.get(i);
            int countU=freq.get(u);
            if(countU>=2){
                int sum=u+u;
                int pairs=countU/2;
                pairCount.put(sum,pairCount.getOrDefault(sum,0)+pairs);
            }
            for(int j=i+1;j<unique;j++){
                int sum=u+uniqueHeights.get(j);
                int pairs=Math.min(freq.get(u),freq.get(uniqueHeights.get(j)));
                pairCount.put(sum,pairCount.getOrDefault(sum,0)+pairs);
            }
        }
        int max=1;
        for(int key:freq.keySet()){
            max=Math.max(max,freq.get(key)+pairCount.getOrDefault(key,0));
        }
        for(int key:pairCount.keySet()){
            max=Math.max(max,freq.getOrDefault(key,0)+pairCount.get(key));
        }
        return max;
    }
}