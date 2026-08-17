class Solution {
    public int maximumGap(String skill, String station) {
        int n=skill.length();
        int suff[]=new int[n];
        int pref[]=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            while(station.charAt(j)!=skill.charAt(i)) j++;
            pref[i]=j;
            j++;
        }
        j=station.length()-1;
        for(int i=n-1;i>=0;i--){
            while(station.charAt(j)!=skill.charAt(i)) j--;
            suff[i]=j;
            j--;
        }
        int max=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,suff[i]-pref[i-1]);
        }
        return max;
    }
}