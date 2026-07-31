class Solution {
    public int minimumPushes(String word) {
        int count[][]=new int[26][2];
        for(int i=0;i<26;i++) count[i][0]=i;
        for(char ch:word.toCharArray()){
            count[ch-'a'][1]++;
        }
        Arrays.sort(count,(a,b)->Integer.compare(b[1],a[1]));
        int num=2;
        int ans=0;
        int t=1;
        for(int i=0;i<26;i++){
            ans+=count[i][1]*t;
            num++;
            if(num>9){
                num=2;
                t++;
            }
        }
        return ans;
    }
}