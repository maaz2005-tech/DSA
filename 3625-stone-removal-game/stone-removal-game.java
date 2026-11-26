class Solution {
    public boolean canAliceWin(int n) {
        int toRemove=10;
        while(n>0){
            n-=toRemove;
            toRemove--;
        }
        if(n==0) return (toRemove%2==0)?false:true;
        return (toRemove%2==0)?true:false;
    }
}