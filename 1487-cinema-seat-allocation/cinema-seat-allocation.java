class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,boolean[]> map=new HashMap<>();
        int ans=2*n;
        for(int res[]:reservedSeats){
            if(!map.containsKey(res[0])){
                map.put(res[0],new boolean[3]);
            }
            boolean can[]=map.get(res[0]);
            if(res[1]==2 || res[1]==3){
                can[0]=true;
            }
            else if(res[1]==4 || res[1]==5){
                can[0]=true;
                can[1]=true;
            }
            else if(res[1]==6 || res[1]==7){
                can[1]=true;
                can[2]=true;
            }
            else if(res[1]==8 || res[1]==9){
                can[2]=true;
            }
        }
        for(int row:map.keySet()){
            boolean can[]=map.get(row);
            if(can[1]){
                if(can[0]&&can[2]){
                    ans-=2;
                }
                else{
                    ans-=1;
                }
            }
            else{
                if(can[0]|can[2]) ans-=1;
            }
        }
        return ans;
    }
}