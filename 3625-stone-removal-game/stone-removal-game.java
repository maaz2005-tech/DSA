class Solution {
    public boolean canAliceWin(int n) {
        int toRemove=10;
        while(n>=0){
            n-=toRemove;
            toRemove--;
        }
        return (toRemove%2==0)?true:false;
    }
}